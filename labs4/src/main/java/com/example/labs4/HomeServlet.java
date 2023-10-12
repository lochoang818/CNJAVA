package com.example.labs4;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if (page == null || page.isEmpty()) {
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.println("Welcome to our website");
            out.close();
        } else {
            String viewName ="/"+ page + ".jsp";
            getServletContext().getRequestDispatcher(viewName).forward(request, response);
        }

    }
    public void destroy() {
    }
}