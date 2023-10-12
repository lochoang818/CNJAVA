package com.example.labs4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
@WebServlet(name = "UploadServlet", value = "/UploadServlet")

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("upload.jsp");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");

        String saveDirectory = "uploads";
        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + saveDirectory;

        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }

        try {
            String name = request.getParameter("name");
            Part part = request.getPart("image");
            String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

            if (Files.exists(Paths.get(savePath + File.separator + filename)) && request.getParameter("override") != null) {
                Files.delete(Paths.get(savePath + File.separator + filename));
            }

            part.write(savePath + File.separator + filename);

            PrintWriter out = response.getWriter();
            out.println("File " + filename + " uploaded successfully to " + savePath);
        } catch (IOException | ServletException e) {

        }
    }



}