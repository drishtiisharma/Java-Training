package com.servlets;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.pojo.Order;
import com.dao.OrderDao;
import com.daoimpl.OrderDaoImpl;
import java.util.List;

@WebServlet("/OrderHistoryServlet")
public class OrderHistoryServlet extends HttpServlet {
    
    // Database configuration (consistent with your OrderServlet)
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String JDBC_USER = "your_username";
    private static final String JDBC_PASSWORD = "your_password";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Connection conn = null;
        
        try {
            // 1. Get logged-in username from session
            String username = (String) session.getAttribute("username");
            
            if (username == null) {
                session.setAttribute("error", "Please login to view orders");
                response.sendRedirect("login.jsp");
                return;
            }
            
            // 2. Establish database connection
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            
            // 3. Get orders using DAO pattern (consistent with your implementation)
            OrderDao orderDao = new OrderDaoImpl(conn);
            List<Order> orders = orderDao.getOrdersByUser(username);
            
            // 4. Store orders in request attributes
            request.setAttribute("orders", orders);
            
            // 5. Forward to myorders.jsp
            request.getRequestDispatcher("myorders.jsp").forward(request, response);
            
        } catch (Exception e) {
            session.setAttribute("error", "Failed to load orders: " + e.getMessage());
            response.sendRedirect("error.jsp");
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void init() throws ServletException {
        try {
            // Load JDBC driver (consistent with your OrderServlet)
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException("JDBC driver not found", e);
        }
    }
}