package com.daoimpl;

import com.dao.OrderDao;
import com.pojo.Order;
import com.pojo.OrderItem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private Connection conn;
    
    public OrderDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int createOrder(Order order) throws Exception {
        String sql = "INSERT INTO orders (username, total_amount, status, shipping_address, payment_method) " +
                     "VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, order.getUsername());
            pstmt.setDouble(2, order.getTotalAmount());
            pstmt.setString(3, order.getStatus());
            pstmt.setString(4, order.getShippingAddress());
            pstmt.setString(5, order.getPaymentMethod());
            
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows == 0) {
                throw new SQLException("Creating order failed, no rows affected.");
            }
            
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                } else {
                    throw new SQLException("Creating order failed, no ID obtained.");
                }
            }
        }
    }

    @Override
    public boolean addOrderItem(OrderItem item) throws Exception {
        String sql = "INSERT INTO order_items (order_id, pid, quantity, price) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, item.getOrderId());
            pstmt.setInt(2, item.getPid());
            pstmt.setInt(3, item.getQuantity());
            pstmt.setDouble(4, item.getPrice());
            
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public Order getOrderWithItems(int orderId) throws Exception {
        String orderSql = "SELECT * FROM orders WHERE order_id = ?";
        String itemsSql = "SELECT oi.*, p.pname, p.image_url FROM order_items oi " +
                         "JOIN product p ON oi.pid = p.pid " +
                         "WHERE oi.order_id = ?";
        
        Order order = null;
        
        // Get order details
        try (PreparedStatement pstmt = conn.prepareStatement(orderSql)) {
            pstmt.setInt(1, orderId);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    order = new Order();
                    order.setOrderId(rs.getInt("order_id"));
                    order.setUsername(rs.getString("username"));
                    order.setOrderDate(rs.getTimestamp("order_date"));
                    order.setTotalAmount(rs.getDouble("total_amount"));
                    order.setStatus(rs.getString("status"));
                    order.setShippingAddress(rs.getString("shipping_address"));
                    order.setPaymentMethod(rs.getString("payment_method"));
                }
            }
        }
        
        if (order != null) {
            // Get order items
            try (PreparedStatement pstmt = conn.prepareStatement(itemsSql)) {
                pstmt.setInt(1, orderId);
                
                try (ResultSet rs = pstmt.executeQuery()) {
                    List<OrderItem> items = new ArrayList<>();
                    while (rs.next()) {
                        OrderItem item = new OrderItem();
                        item.setItemId(rs.getInt("item_id"));
                        item.setOrderId(rs.getInt("order_id"));
                        item.setPid(rs.getInt("pid"));
                        item.setQuantity(rs.getInt("quantity"));
                        item.setPrice(rs.getDouble("price"));
                        item.setProductName(rs.getString("pname"));
                        item.setImageUrl(rs.getString("image_url"));
                        
                        items.add(item);
                    }
                    order.setItems(items); 
                }
            }
        }
        
        return order;
    }
    
    @Override
    public List<Order> getOrdersByUser(String username) throws Exception {
        String sql = "SELECT * FROM orders WHERE username = ? ORDER BY order_date DESC";
        List<Order> orders = new ArrayList<>();
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt("order_id"));
                order.setOrderDate(rs.getTimestamp("order_date"));
                order.setTotalAmount(rs.getDouble("total_amount"));
                order.setStatus(rs.getString("status"));
                orders.add(order);
            }
        }
        return orders;
    }
}