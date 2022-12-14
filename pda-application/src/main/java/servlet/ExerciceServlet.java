package servlet;

import entity.Activite;
import entity.Exercice;
import entity.Status;
import jakarta.persistence.EnumType;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.implementation.adminServiceImp;
import service.implementation.exerciceServiceImp;
import service.implementation.activiteServiceImp;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ExerciceServlet", urlPatterns = {"/exercice", "/exdelete"})
public class ExerciceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = null;
        int id;
        exerciceServiceImp ex = null;
    	id = Integer.parseInt(request.getParameter("id"));
    	ex = new exerciceServiceImp();
    	ex.delete(ex.find(id));
    	dispatcher = request.getRequestDispatcher("exercice.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	try {
            RequestDispatcher dispatcher = null;
            int id;
            int fk;
            exerciceServiceImp ex = null;
            activiteServiceImp ac = null;

            Exercice exercice = null;
            Activite activite = null;

            SimpleDateFormat sdf = null;
            String dateDeb = null;
            Date debut = null;

            String dateFin = null;
            Date fin = null;

            String ann = null;
            String stat = null;
            int act ;

            id = Integer.parseInt(request.getParameter("id"));

        	
        	
        	ex = new exerciceServiceImp();
            exercice=new Exercice();
            ac = new activiteServiceImp();
            activite=new Activite();
            
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            dateDeb = request.getParameter("dateDebut");
            debut = sdf.parse(dateDeb);

            dateFin = request.getParameter("dateFin");
            fin = sdf.parse(dateFin);
            
            ann = request.getParameter("annee");
            stat = request.getParameter("status");



            exercice.setDate_debut(debut);
            exercice.setDate_fin(fin);
            exercice.setAnnee(ann);
            exercice.setStatus(Status.valueOf(stat));







            

            if (id == 0) {
                fk = Integer.parseInt(request.getParameter("fkexercice"));
                activite = ac.find(fk);
                exercice.setActivite(activite);
                Exercice added = ex.add(exercice);				
			} else {
                act = Integer.parseInt(request.getParameter("act"));
                activite = ac.find(act);
                exercice.setActivite(activite);
                exercice.setId_exercice(id);
                Exercice updated = ex.update(exercice);
			}
            
            dispatcher = request.getRequestDispatcher("exercice.jsp");
            dispatcher.forward(request, response);
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}
