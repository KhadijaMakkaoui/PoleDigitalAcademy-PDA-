package servlet;

import entity.Admin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.implementation.adminServiceImp;

import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login", "/logout"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;
        String login = null;
        session.setAttribute("login", login);
        dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        adminServiceImp asi = new adminServiceImp();
        try {
            String login = request.getParameter("username");
            String password = request.getParameter("password");

            HttpSession session = request.getSession();
            RequestDispatcher dispatcher = null;

            boolean asicon = asi.auth(login, password);
            if (asicon==true) {
                    session.setAttribute("login", login);
                    dispatcher = request.getRequestDispatcher("HomeServlet");
                } else {
                    session.setAttribute("status", "failed");
            }
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
