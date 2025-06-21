package com.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import com.daoimpl.ProductDaoImpl;

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            // Get product ID from request
            String pidStr = request.getParameter("pid");
            int pid = Integer.parseInt(pidStr);

            // Delete the product using DAO
            ProductDaoImpl productDao = new ProductDaoImpl();
            boolean success = productDao.deleteProduct(pid);

            // Prepare a message
            HttpSession session = request.getSession();
            if (success) {
                session.setAttribute("msg", "Product deleted successfully!");
            } else {
                session.setAttribute("msg", "Failed to delete the product!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Set error message if something goes wrong
            HttpSession session = request.getSession();
            session.setAttribute("msg", "Error occurred: " + e.getMessage());
        }

        // Redirect back to the product.jsp page
        response.sendRedirect(request.getContextPath() + "/product.jsp");
    }
}
