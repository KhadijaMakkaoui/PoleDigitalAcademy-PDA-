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

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ExerciceServlet", value = "/exercice")
public class ExerciceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	exerciceServiceImp ex = new exerciceServiceImp();
            RequestDispatcher dispatcher = null;
            Exercice exercice=new Exercice();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


            String dateDeb = request.getParameter("dateDebut");
            Date debut = sdf.parse(dateDeb);

            String dateFin = request.getParameter("dateFin");
            Date fin = sdf.parse(dateFin);
            
            String ann = request.getParameter("annee");
            String stat = request.getParameter("status");
            
            exercice.setDate_debut(debut);
            exercice.setDate_fin(fin);
            exercice.setAnnee(ann);
            exercice.setStatus(Status.valueOf(stat));

            Exercice added = ex.add(exercice);
            
            dispatcher = request.getRequestDispatcher("exercice.jsp");
            dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

    	
        /*try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateDeb = request.getParameter("dateDebut");
            Date debut = sdf.parse(dateDeb);

            String dateFin = request.getParameter("dateFin");
            Date fin = sdf.parse(dateFin);

            String annee = request.getParameter("annee");
            String status =request.getParameter("status");

            Exercice exercice=new Exercice();
            exercice.setAnnee(annee);

            exercice.setStatus(Status.valueOf(status));

            exercice.setDate_debut(debut);
            exercice.setDate_fin(fin);
            Activite a=new Activite();
            exercice.setActivite(a);

            
            */

            

          /* dispatcher = request.getRequestDispatcher("HomeServlet");
           if (added.getId_exercice()>0) {


            } else {
               session.setAttribute("status", "failed");


            }
                session.setAttribute("status", "failed");
                response.sendRedirect("home");

        } catch (Exception e) {
          e.printStackTrace();
        }*/
    }
}
