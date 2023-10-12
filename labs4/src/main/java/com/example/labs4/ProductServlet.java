package com.example.labs4;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    ArrayList<Product> lstProduct;

    @Override
    public void init() throws ServletException {
        super.init();
        lstProduct = new ArrayList<>();
        lstProduct.add(new Product(1,"nha",123123));
        lstProduct.add(new Product(2,"bed",123));
        lstProduct.add(new Product(3,"bottle",23));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JsonResponse jsonResponse;
        if(request.getParameter("id")==null){
            jsonResponse = new JsonResponse(0, "Đọc sản phẩm thành công", lstProduct);


        }
        else{
            int id =Integer.parseInt(request.getParameter("id"));
            Optional<Product> productOptional = lstProduct.stream()
                    .filter(product -> product.id == id)
                    .findFirst();
            if(productOptional.isPresent()){
                 jsonResponse = new JsonResponse(0, "Đọc sản phẩm thành công", productOptional);

            }
            else{
                jsonResponse = new JsonResponse(2, "Không tìm thấy sản phẩm với mã số "+id);

            }
        }
        Gson gson = new Gson();
        String json = gson.toJson(jsonResponse);

        PrintWriter out = response.getWriter();
        out.print(json);
/*
        out.flush();
*/

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        Optional<Product> existingProduct = lstProduct.stream()
                .filter(product -> product.id== id)
                .findFirst();

        if (existingProduct.isPresent()) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            Gson gson = new Gson();
            PrintWriter out = response.getWriter();
            JsonResponse jsonResponse = new JsonResponse(2, "Sản phẩm đã tồn tại với id: "+id);

            String json = gson.toJson(jsonResponse);

            out.print(json);
            out.flush();
        } else {
            Product p = new Product(id, name, price);
            lstProduct.add(p);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            Gson gson = new Gson();
            PrintWriter out = response.getWriter();

            JsonResponse jsonResponse = new JsonResponse(2, "Thêm sản phẩm thành công "+id,p );

            String json = gson.toJson(jsonResponse);

            out.print(json);
            out.flush();
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        JsonObject jsonObject = JsonParser.parseString(sb.toString()).getAsJsonObject();

        int id =Integer.parseInt(jsonObject.get("id").getAsString()) ;

        // Trả về phản hồi

        String name = jsonObject.get("name").getAsString();
        double price = Double.parseDouble(jsonObject.get("price").getAsString());

        Optional<Product> existingProduct = lstProduct.stream()
                .filter(product -> product.id== id)
                .findFirst();

        if (existingProduct.isPresent()) {
            // Product with the given ID exists, update its information
            Product productToUpdate = existingProduct.get();
            productToUpdate.setName(name);
            productToUpdate.setPrice(price);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            Gson gson = new Gson();
            JsonResponse jsonResponse = new JsonResponse(2, "Cập nhật sản phẩm thành công "+id,existingProduct );
            String json = gson.toJson(jsonResponse);

            PrintWriter out = response.getWriter();

            out.print(json);
            out.flush();
        } else {
            // Product with the given ID doesn't exist, return an error response
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            Gson gson = new Gson();
            JsonResponse jsonResponse = new JsonResponse(2, "Không tìm thấy sản phẩm với mã: "+id );
            PrintWriter out = response.getWriter();
            String json = gson.toJson(jsonResponse);

            out.print(json);
            out.flush();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        JsonObject jsonObject = JsonParser.parseString(sb.toString()).getAsJsonObject();

        int id =Integer.parseInt(jsonObject.get("id").getAsString()) ;
        Optional<Product> p = lstProduct.stream()
                .filter(product -> product.id == id)
                .findFirst();
        boolean removed = lstProduct.removeIf(product -> product.id == id);

        if (removed) {
            // Product with the given ID was found and removed
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            Gson gson = new Gson();
            JsonResponse jsonResponse = new JsonResponse(2, "Xóa sản phẩm thành công "+id,p );
            PrintWriter out = response.getWriter();
            String json = gson.toJson(jsonResponse);

            out.print(json);
            out.flush();
        } else {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            Gson gson = new Gson();
            JsonResponse jsonResponse = new JsonResponse(2, "Không tìm thấy sản phẩm với mã: "+id );
            PrintWriter out = response.getWriter();
            String json = gson.toJson(jsonResponse);

            out.print(json);
            out.flush();
        }
    }

}