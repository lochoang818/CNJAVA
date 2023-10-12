package com.example.labs4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    HashMap<String,String> user= new HashMap<>();

    @Override
    public void init() throws ServletException {
        user.put("loc@gmail.com","123");
        user.put("lochoang@gmail.com","123");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email= request.getParameter("Email");
        String password= request.getParameter("password");
        System.out.println(password);
        System.out.println(user.get(email));
        if(user.containsKey(email)&&user.get(email).equals(password) ){
            PrintWriter out = response.getWriter();
            out.println("<h1>Welcome</h1>");
        }
        else {
            PrintWriter out = response.getWriter();
            out.println("<h1>Wrong</h1>");
        }
    }
}