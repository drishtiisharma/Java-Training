package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pojo.Product;
import com.daoimpl.ProductDaoImpl;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDaoImpl productDao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            int pid = Integer.parseInt(request.getParameter("pid"));
            productDao = new ProductDaoImpl();
            Product product = productDao.getProductById(pid);

            if (product != null) {
                request.setAttribute("product", product);
                request.getRequestDispatcher("productDetail.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Product not found!");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid product ID!");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "System error occurred");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}