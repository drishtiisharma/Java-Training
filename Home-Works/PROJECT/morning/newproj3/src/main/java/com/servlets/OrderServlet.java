package com.servlets;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.pojo.CartItem;
import java.util.*;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/furni";
    private static final String JDBC_USER = "username";
    private static final String JDBC_PASSWORD = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Connection conn = null;
        
        try {
            // 1. Get form data
            String billingName = request.getParameter("billingName");
            String billingAddress = request.getParameter("billingAddress");
            String billingEmail = request.getParameter("billingEmail");
            String billingPhone = request.getParameter("billingPhone");
            String paymentMethod = request.getParameter("paymentMethod");
            
            // 2. Get cart items
            List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
            if(cartItems == null || cartItems.isEmpty()) {
                session.setAttribute("error", "Your cart is empty");
                response.sendRedirect("cart.jsp");
                return;
            }
            
            double total = calculateTotal(cartItems);
            
            // 3. DB connection
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            conn.setAutoCommit(false);
            
            // 4. DEMO: Set random instant status
            String status = getDemoStatus(paymentMethod);
            
            // 5. Save order (modified SQL to include status)
            int orderId = saveOrderToDatabase(conn, billingName, billingEmail, billingPhone, 
                                           billingAddress, cartItems, total, paymentMethod, status);
            
            // 6. Prepare data for JSP
            request.setAttribute("orderId", orderId);
            request.setAttribute("status", status); // Add status to request
            // ... [keep other attributes] ...
            
            // 7. Clear cart and commit
            session.removeAttribute("cartItems");
            conn.commit();
            
            // 8. Forward
            request.getRequestDispatcher("orderSummary.jsp").forward(request, response);
            
        } catch (Exception e) {
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            session.setAttribute("error", "Order failed: " + e.getMessage());
            response.sendRedirect("checkout.jsp");
        } finally {
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    
    // DEMO: Instant status generator
    private String getDemoStatus(String paymentMethod) {
        Random rand = new Random();
        if ("COD".equals(paymentMethod)) {
            return rand.nextBoolean() ? "Pending" : "Shipped"; // 50/50 for COD
        } else {
            return rand.nextBoolean() ? "Processing" : "Delivered"; // 50/50 for Online
        }
    }
    
    // Modified to include status
    private int saveOrderToDatabase(Connection conn, String name, String email, String phone, 
                                  String address, List<CartItem> items, 
                                  double total, String paymentMethod, String status) throws SQLException {
        
        String orderSQL = "INSERT INTO orders (customer_name, email, phone, address, " +
                         "total_amount, payment_method, status, order_date) " + // Added status
                         "VALUES (?, ?, ?, ?, ?, ?, ?, NOW())";
        
        try (PreparedStatement orderStmt = conn.prepareStatement(orderSQL, Statement.RETURN_GENERATED_KEYS)) {
            orderStmt.setString(1, name);
            orderStmt.setString(2, email);
            orderStmt.setString(3, phone);
            orderStmt.setString(4, address);
            orderStmt.setDouble(5, total);
            orderStmt.setString(6, paymentMethod);
            orderStmt.setString(7, status); // Set status
            
            orderStmt.executeUpdate();
            
            try (ResultSet rs = orderStmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int orderId = rs.getInt(1);
                    
                    // Insert items (unchanged)
                    String itemSQL = "INSERT INTO order_items (order_id, product_name, quantity, unit_price) " +
                                    "VALUES (?, ?, ?, ?)";
                    try (PreparedStatement itemStmt = conn.prepareStatement(itemSQL)) {
                        for (CartItem item : items) {
                            itemStmt.setInt(1, orderId);
                            itemStmt.setString(2, item.getName());
                            itemStmt.setInt(3, item.getQuantity());
                            itemStmt.setDouble(4, item.getPrice());
                            itemStmt.addBatch();
                        }
                        itemStmt.executeBatch();
                    }
                    return orderId;
                }
            }
        }
        throw new SQLException("Failed to generate order ID");
    }
    
    private double calculateTotal(List<CartItem> items) {
        return items.stream()
                   .mapToDouble(item -> item.getPrice() * item.getQuantity())
                   .sum();
    }
    
    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException("JDBC driver not found", e);
        }
    }
}