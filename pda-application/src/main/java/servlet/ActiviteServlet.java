package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import service.implementation.activiteServiceImp;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entity.Activite;
import entity.Etat;
import entity.TypeActivite;

@WebServlet(name = "ActiviteServlet", urlPatterns = {"/activite", "/acdelete"})
public class ActiviteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = null;
        int id;
        activiteServiceImp ex = null;
    	id = Integer.parseInt(request.getParameter("id"));
    	ex = new activiteServiceImp();
    	ex.delete(ex.find(id));
    	dispatcher = request.getRequestDispatcher("activite.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
            RequestDispatcher dispatcher = null;
            int id;
            activiteServiceImp ac = null;
            Activite activite = null;
            SimpleDateFormat sdf = null;
            
            String titre = null;
            String type = null;
            
            String dateDeb = null;
            Date debut = null;

            String dateFin = null;
            Date fin = null;

            String descriptif = null;
            String etat = null;
            
        	id = Integer.parseInt(request.getParameter("id"));
        	ac = new activiteServiceImp();
            activite = new Activite();
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            titre = request.getParameter("titre");
            type = request.getParameter("type");
            
            dateDeb = request.getParameter("dateDebut");
            debut = sdf.parse(dateDeb);

            dateFin = request.getParameter("dateFin");
            fin = sdf.parse(dateFin);
            
            descriptif = request.getParameter("descriptif");
            etat = request.getParameter("etat");
            

            activite.setTitre(titre);
            activite.setType(TypeActivite.valueOf(type));
            activite.setDate_debut(debut);
            activite.setDate_fin(fin);
            activite.setDescriptif(descriptif);
            activite.setEtat(Etat.valueOf(etat));

            if (id == 0) {
                Activite added = ac.add(activite);				
			} else {
				activite.setId_activite(id);
                Activite updated = ac.update(activite);
			}
            
            dispatcher = request.getRequestDispatcher("activite.jsp");
            dispatcher.forward(request, response);
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}
