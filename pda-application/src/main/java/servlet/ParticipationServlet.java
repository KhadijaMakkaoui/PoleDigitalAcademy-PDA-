package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import service.implementation.activiteServiceImp;
import service.implementation.participationServiceImp;
import service.implementation.participantServiceImp;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import entity.Activite;
import entity.Participation;
import entity.Participant;


@WebServlet(name = "ParticipationServlet", urlPatterns = {"/participation", "/pationdelete"})
public class ParticipationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*RequestDispatcher dispatcher = null;
        int id;
        activiteServiceImp ac = null;
    	id = Integer.parseInt(request.getParameter("id"));
    	ac = new activiteServiceImp();
    	ac.delete(ac.find(id));
    	dispatcher = request.getRequestDispatcher("activite.jsp");
        dispatcher.forward(request, response);*/
	}
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
    		RequestDispatcher dispatcher = null;
            int id;
            int idac;
            int idpa;

            activiteServiceImp ac = null;
            Activite activite = null;
            participantServiceImp pa = null;
            Participant participant = null;
            participationServiceImp pation = null;
            Participation participation = null;

            
        	id = Integer.parseInt(request.getParameter("id"));
        	idac = Integer.parseInt(request.getParameter("fkactivite"));
        	idpa = Integer.parseInt(request.getParameter("fkpar"));

        	ac = new activiteServiceImp();
            activite = new Activite();
            pa= new participantServiceImp();
            participant = new Participant();
            pation= new participationServiceImp();
            participation = new Participation();
            
			activite = ac.find(idac);
			participant = pa.find(idpa);

			participation.setParticipant(participant);
			participation.setActivite(activite);
			participation.setPresent(false);
			
			
			Participation added = pation.add(participation);
            
                
                
                
                
                /*if (id == -1) {
			} else {
				
	            if (id == 0) {
	                Activite added = ac.add(activite);				
				} else {
					activite.setId_activite(id);
	                Activite updated = ac.update(activite);
				}
			}*/
            dispatcher = request.getRequestDispatcher("activite.jsp");
            dispatcher.forward(request, response);
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
}