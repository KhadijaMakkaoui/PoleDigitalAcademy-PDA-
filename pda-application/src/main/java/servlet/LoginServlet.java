package servlet;

import entity.Admin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.implementation.adminServiceImp;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = new Admin();
        admin.setLogin("khadija");
        admin.setPassword("111");
        adminServiceImp asi = new adminServiceImp();
        asi.add(admin);
        try {
            String login = request.getParameter("username");
            String password = request.getParameter("password");

            HttpSession session = request.getSession();
            RequestDispatcher dispatcher = null;

            //if (login != null && password != null) {
                boolean asicon = asi.auth(login, password);


            if (asicon==true) {
                    session.setAttribute("login", login);
                    dispatcher = request.getRequestDispatcher("HomeServlet");

                } else {
                    session.setAttribute("status", "failed");


            }
            /*} else {
                session.setAttribute("status", "failed");
                response.sendRedirect("home");
            }*/

            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
