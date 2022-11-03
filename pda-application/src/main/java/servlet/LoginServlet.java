package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.implementation.adminServiceImp;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String login = request.getParameter("username");
            String password = request.getParameter("password");
            HttpSession session = request.getSession();
            RequestDispatcher dispatcher = null;

            if (login != null && password != null) {
                adminServiceImp asi = new adminServiceImp();
                boolean asicon = asi.auth(login, password);
                if (asicon) {
                    session.setAttribute("login", login);
                    dispatcher = request.getRequestDispatcher("index.jsp");
                } else {
                    session.setAttribute("status", "failed");
                    dispatcher = request.getRequestDispatcher("login.jsp");
                }
            } else {
                session.setAttribute("status", "failed");
                dispatcher = request.getRequestDispatcher("login.jsp");
            }
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
