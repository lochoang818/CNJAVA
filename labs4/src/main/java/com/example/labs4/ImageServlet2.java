package com.example.labs4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet(name = "ImageServlet2", value = "/image2")
public class ImageServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filePath = getServletContext().getRealPath("images/cat.jpg");
        File imageFile = new File(filePath);
        response.setContentType("image/jpg");

        response.setContentLength((int) imageFile.length());
        response.setHeader("Content-Disposition", "attachment; filename=cat.jpg");

        FileInputStream in = new FileInputStream(imageFile);
        OutputStream out = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int numRead = 0;
        while ((numRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, numRead);
        }

        in.close();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}