package com.dao;

import com.pojo.Order;
import com.pojo.OrderItem;
import java.util.List;

public interface OrderDao {
    int createOrder(Order order) throws Exception;
    boolean addOrderItem(OrderItem item) throws Exception;
    Order getOrderWithItems(int orderId) throws Exception; 
    List<Order> getOrdersByUser(String username) throws Exception;
}