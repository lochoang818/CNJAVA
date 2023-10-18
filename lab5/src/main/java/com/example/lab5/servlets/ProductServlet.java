package com.example.lab5.servlets;

import com.example.lab5.Dao.ProductDAO;
import com.example.lab5.Dao.UserDAO;
import com.example.lab5.Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "product", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
        List<Product> products = productDAO.getAll();
        getServletContext().setAttribute("products", products);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("userName");
        request.setAttribute("username", username);
        List<Product> products = productDAO.getAll();
        request.setAttribute("products", products);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ( (request.getParameter("name") == null ||  request.getParameter("name").trim().isEmpty())&& !action.equals("delete") ) {
            request.setAttribute("errorMessage", "Vui lòng nhập tên sản phẩm");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            if (action != null && action.equals("delete")) {
                int productId = Integer.parseInt(request.getParameter("id"));
                productDAO.delete(productId);
            } else {
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                Product product = new Product(name, price);
                productDAO.add(product);
            }
            response.sendRedirect(request.getContextPath() + "/ProductServlet");
        }
    }
}