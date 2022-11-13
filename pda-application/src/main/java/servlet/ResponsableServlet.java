package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import service.implementation.responsableServiceImp;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import entity.Etat;
import entity.Responsable;
import entity.Role;
import entity.TypeResponsable;

@WebServlet(name = "ResponsableServlet", urlPatterns = {"/responsable", "/redelete"})
public class ResponsableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = null;
        int id;
        responsableServiceImp re = null;
    	id = Integer.parseInt(request.getParameter("id"));
    	re = new responsableServiceImp();
    	re.delete(re.find(id));
    	dispatcher = request.getRequestDispatcher("responsable.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
            RequestDispatcher dispatcher = null;
            int id;
            responsableServiceImp re = null;
            Responsable responsable = null;            
            String nom = null;
            String prenom = null;
            String email = null;
            String phone = null;
            String domaine = null;
            String etat = null;
            String role = null;
            String type = null;


        	id = Integer.parseInt(request.getParameter("id"));
        	re = new responsableServiceImp();
        	responsable = new Responsable();
            
        	nom = request.getParameter("nom");
            prenom = request.getParameter("prenom");
            email = request.getParameter("email");
            phone = request.getParameter("phone");
            domaine = request.getParameter("domaine");
            etat = request.getParameter("etat");
            role = request.getParameter("role");
            type = request.getParameter("type");


            responsable.setNom(nom);
            responsable.setPrenom(prenom);
            responsable.setEmail(email);
            responsable.setPhone(phone);
            responsable.setDomaine(domaine);
            responsable.setEtat(Etat.valueOf(etat));
            responsable.setRole(Role.valueOf(role));
            responsable.setType(TypeResponsable.valueOf(type));


            if (id == 0) {
            	Responsable added = re.add(responsable);				
			} else {
				responsable.setId_user(id);
				Responsable updated = re.update(responsable);
			}
            
            dispatcher = request.getRequestDispatcher("responsable.jsp");
            dispatcher.forward(request, response);
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}
