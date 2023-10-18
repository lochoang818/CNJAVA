package com.example.lab5.servlets;

import com.example.lab5.Dao.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {





        String userName = request.getParameter("userName");
       String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        if (userDAO.checkLogin(userName,password)){
            HttpSession session = request.getSession();
            session.setAttribute("UserName", userName);
            String rememberCheckbox = request.getParameter("cb1");
            if (rememberCheckbox != null && rememberCheckbox.equals("Remember username and password")) {
                Cookie usernameCookie = new Cookie("username", userName);
                usernameCookie.setMaxAge(30 * 24 * 60 * 60);
                response.addCookie(usernameCookie);

                Cookie passwordCookie = new Cookie("password", password);
                passwordCookie.setMaxAge(30 * 24 * 60 * 60);
                response.addCookie(passwordCookie);
            }

            response.sendRedirect(request.getContextPath() + "/ProductServlet");
        }
        else {
            String message = "Username or Password is wrong";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}