package com.example.lab5.servlets;

import com.example.lab5.Dao.UserDAO;
import com.example.lab5.Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "register", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email= request.getParameter("email");
        String password= request.getParameter("password");
        String Cpassword = request.getParameter("confirm-password");

        String name= request.getParameter("name");
        if(password.length()<6){
            String message = "Password must at least 6 character";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
            dispatcher.forward(request, response);
        }
        if(!password.equals(Cpassword)){
            String message = "Confirm-password does not match";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
            dispatcher.forward(request, response);
        }
        UserDAO userDAO = new UserDAO();
        userDAO.add(new User(email,name,password));
        HttpSession session = request.getSession();
        session.setAttribute("UserName", name);

        response.sendRedirect("index.jsp");
    }
}