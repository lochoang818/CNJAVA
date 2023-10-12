package com.example.labs4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        String birthtime = request.getParameter("birthtime");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        String[] favoriteIde = request.getParameterValues("favorite_ide[]");
        String toeic = request.getParameter("toeic");
        String message = request.getParameter("message");

        if (name.isEmpty() || email.isEmpty() || birthday.isEmpty()) {
            response.getWriter().write("Please fill in all required fields.");
        } else {
            response.setContentType("text/html");
            response.getWriter().write("<html><body>");
            response.getWriter().write("<h1>Registration Details</h1>");
            response.getWriter().write("<p>Name: " + name + "</p>");
            response.getWriter().write("<p>Email: " + email + "</p>");
            response.getWriter().write("<p>Birthday: " + birthday + "</p>");
            response.getWriter().write("<p>Birthtime: " + birthtime + "</p>");
            response.getWriter().write("<p>Gender: " + gender + "</p>");
            response.getWriter().write("<p>From: " + country + "</p>");
            response.getWriter().write("<p>Favorite IDEs: ");
            if (favoriteIde != null) {
                for (String ide : favoriteIde) {
                    response.getWriter().write(ide + " ");
                }
            }
            response.getWriter().write("</p>");
            response.getWriter().write("<p>TOEIC Score: " + toeic + "</p>");
            response.getWriter().write("<p>Message: " + message + "</p>");
            response.getWriter().write("</body></html>");
        }
    }
}