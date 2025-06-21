package com.daoimpl;

import com.dao.CustomerDao;
import com.pojo.Customer;
import java.sql.*;

public class CustomerDaoImpl implements CustomerDao{
    private Connection conn; 
    private static final String UPDATE_CUSTOMER_SQL = 
        "UPDATE customer SET username=?, password=?, phone=?, address=?, profile_picture=? WHERE email=?";
    private static final String GET_CUSTOMER_BY_EMAIL_SQL = 
        "SELECT * FROM customer WHERE email=?";

    @Override
    public boolean updateCustomer(Customer customer) {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE_CUSTOMER_SQL)) {
            stmt.setString(1, customer.getUsername());
            stmt.setString(2, customer.getPassword());
            stmt.setString(3, customer.getPhone());
            stmt.setString(4, customer.getAddress());
            stmt.setString(5, customer.getProfilePicture());
            stmt.setString(6, customer.getEmail());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Returns true if update succeeded
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        try (PreparedStatement stmt = conn.prepareStatement(GET_CUSTOMER_BY_EMAIL_SQL)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Customer(
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getString("profile_picture")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Customer not found
    }
}