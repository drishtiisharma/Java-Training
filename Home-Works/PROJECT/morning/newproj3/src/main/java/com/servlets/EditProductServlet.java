package com.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;

import com.daoimpl.ProductDaoImpl;
import com.pojo.Product;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            // Get parameters from request
            int pid = Integer.parseInt(request.getParameter("pid"));
            String pname = request.getParameter("pname");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int cid = Integer.parseInt(request.getParameter("cid"));

            // If you allow updating the image URL:
            String imageUrl = request.getParameter("image_url"); 

            // Create product object
            Product product = new Product();
            product.setPid(pid);
            product.setPname(pname);
            product.setDescription(description);
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setCid(cid);
            product.setImageUrl(imageUrl); // optional if you want to change image

            // Update product in DB
            ProductDaoImpl dao = new ProductDaoImpl();
            boolean success = dao.updateProduct(product);

            // Set message & redirect
            HttpSession session = request.getSession();
            if (success) {
                session.setAttribute("msg", "Product updated successfully!");
            } else {
                session.setAttribute("msg", "Failed to update the product.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("msg", "Error occurred: " + e.getMessage());
        }

        // Redirect back to product list
        response.sendRedirect(request.getContextPath() + "/product.jsp");
    }
}
