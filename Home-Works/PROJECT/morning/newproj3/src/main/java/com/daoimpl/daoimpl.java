package com.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.dao;
import com.pojo.UserInfo;

public class daoimpl implements dao {

    Connection con = null;

    public daoimpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/furni", "root", "root"
            );
            System.out.println("Database connected successfully");
        } catch (Exception e) {
            System.out.println("❌ Error loading JDBC driver or connecting to DB");
            e.printStackTrace();
        }
    }

    @Override
    public boolean addUser(UserInfo u) {
        try {
            // 1. Insert into `customer` table
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO customer (username, password, email, phone, address) VALUES (?, ?, ?, ?, ?)"
            );
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPhone());
            ps.setString(5, u.getAddress());

            int x = ps.executeUpdate();

            // 2. Insert into `user` table only if step 1 is successful
            if (x > 0) {
                ps = con.prepareStatement("INSERT INTO user (username, password, role) VALUES (?, ?, ?)");
                ps.setString(1, u.getUsername());
                ps.setString(2, u.getPassword());
                ps.setString(3, u.getRole()); // e.g. "Customer" or "Admin"

                x = ps.executeUpdate();
                return x > 0;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(UserInfo user) {
        try {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE customer c JOIN user u ON c.username = u.username SET c.username = ?, c.password = ?,  c.phone = ?, c.address = ?, c.profile_picture = ?, u.username = ?, u.password = ? WHERE c.email = ?;"
            );

            ps.setString(1, user.getUsername());  // c.username
            ps.setString(2, user.getPassword());  // c.password
            ps.setString(3, user.getPhone());     // c.phone
            ps.setString(4, user.getAddress());   // c.address
            ps.setString(5, user.getProfilePicture()); // c.profile_picture
            ps.setString(6, user.getUsername());  // u.username
            ps.setString(7, user.getPassword());  // u.password
            ps.setString(8, user.getEmail());     // WHERE c.email

            int x = ps.executeUpdate();
            System.out.println("Rows updated: " + x);
            return x > 0;
        } catch (Exception e) {
            System.out.println("❌ Error updating user:");
            e.printStackTrace();
            return false;
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    @Override
    public boolean deleteUser(String email) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM customer WHERE email = ?");
            ps.setString(1, email);

            int x = ps.executeUpdate();
            System.out.println("Rows deleted: " + x);
            return x > 0;
        } catch (Exception e) {
            System.out.println("❌ Error deleting user:");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public UserInfo getUserByLoginCredential(String credential, String password) {
        try {
            PreparedStatement ps = con.prepareStatement(
                "SELECT u.username, u.password, u.role, c.email, c.phone, c.address " +
                "FROM user u LEFT JOIN customer c ON u.username = c.username " +
                "WHERE (u.username = ? OR c.email = ?) AND u.password = ?"
            );

            ps.setString(1, credential); // login using username or email
            ps.setString(2, credential);
            ps.setString(3, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UserInfo user = new UserInfo();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

                
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));

                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<UserInfo> getAllUsers() {
        List<UserInfo> userList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM customer");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UserInfo user = new UserInfo();

                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone")); // ✅ phone as String
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));

                userList.add(user);
            }

        } catch (Exception e) {
            System.out.println("❌ Error fetching user list:");
            e.printStackTrace();
        }

        return userList;
    }

    public boolean isUsernameExists(String username) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT username FROM customer WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("❌ Error checking username existence:");
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEmailExists(String email) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT email FROM customer WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("❌ Error checking email existence:");
            e.printStackTrace();
            return false;
        }
    }
}
