
package com.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.pojo.CartItem;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        if ("update".equals(action)) {
            session.setAttribute("updateClicked", true); // show remove buttons

            List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");

            if (cartItems != null) {
                for (CartItem item : cartItems) {
                    String paramName = "quantity_" + item.getId();
                    String qtyStr = request.getParameter(paramName);
                    if (qtyStr != null) {
                        try {
                            int qty = Integer.parseInt(qtyStr);
                            item.setQuantity(qty);
                        } catch (NumberFormatException e) {
                            // Optional: handle invalid input
                        }
                    }
                }
            }
        }

        response.sendRedirect("cart.jsp"); // redirect back to cart page
    }
}