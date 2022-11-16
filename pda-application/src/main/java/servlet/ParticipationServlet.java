package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import service.implementation.activiteServiceImp;
import service.implementation.participationServiceImp;
import service.implementation.participantServiceImp;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

import entity.Activite;
import entity.Participation;
import entity.Participant;


@WebServlet(name = "ParticipationServlet", urlPatterns = {"/participation", "/pationdelete"})
public class ParticipationServlet extends HttpServlet {
	@Override    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = null;
        int id;
        participationServiceImp pation = null;
    	id = Integer.parseInt(request.getParameter("id"));
    	pation = new participationServiceImp();
    	pation.delete(pation.find(id));
    	dispatcher = request.getRequestDispatcher("participation.jsp");
        dispatcher.forward(request, response);
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

            ac = new activiteServiceImp();
            activite = new Activite();
            pa= new participantServiceImp();
            participant = new Participant();
            pation= new participationServiceImp();
            participation = new Participation();
        	id = Integer.parseInt(request.getParameter("id"));
        	if(id==-1){
                idac = Integer.parseInt(request.getParameter("fkactivite"));
                idpa = Integer.parseInt(request.getParameter("fkpar"));

                activite = ac.find(idac);
                participant = pa.find(idpa);

                participation.setParticipant(participant);
                participation.setActivite(activite);
                participation.setPresent(false);

                Participation added = pation.add(participation);
            }else{

                idac = Integer.parseInt(request.getParameter("fkac"));
                List<Participation> palist = null;
                palist = pation.findByActivite(idac);
                request.setAttribute("List", palist);
            }

            dispatcher = request.getRequestDispatcher("participation.jsp");
            dispatcher.forward(request, response);
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
}