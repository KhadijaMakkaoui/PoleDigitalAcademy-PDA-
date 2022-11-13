package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import service.implementation.participantServiceImp;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import entity.Participant;
import entity.Role;

@WebServlet(name = "ParticipantServlet", urlPatterns = {"/participant", "/padelete"})
public class ParticipantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = null;
        int id;
        participantServiceImp pa = null;
    	id = Integer.parseInt(request.getParameter("id"));
    	pa = new participantServiceImp();
    	pa.delete(pa.find(id));
    	dispatcher = request.getRequestDispatcher("participant.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
            RequestDispatcher dispatcher = null;
            int id;
            participantServiceImp pa = null;
            Participant participant = null;            
            String nom = null;
            String prenom = null;
            String email = null;
            String phone = null;
            String domaine = null;
            String structure = null;
            String role = null;


            
        	id = Integer.parseInt(request.getParameter("id"));
        	pa = new participantServiceImp();
        	participant = new Participant();
            
        	nom = request.getParameter("nom");
            prenom = request.getParameter("prenom");
            email = request.getParameter("email");
            phone = request.getParameter("phone");
            domaine = request.getParameter("domaine");
            structure = request.getParameter("structure");
            role = request.getParameter("role");


            participant.setNom(nom);
            participant.setPrenom(prenom);
            participant.setEmail(email);
            participant.setPhone(phone);
            participant.setDomaine(domaine);
            participant.setStructure(structure);
            participant.setRole(Role.valueOf(role));

            if (id == 0) {
            	Participant added = pa.add(participant);				
			} else {
				participant.setId_user(id);
				Participant updated = pa.update(participant);
			}
            
            dispatcher = request.getRequestDispatcher("participant.jsp");
            dispatcher.forward(request, response);
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}
