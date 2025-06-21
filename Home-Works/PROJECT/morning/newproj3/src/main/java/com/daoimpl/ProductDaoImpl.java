package com.daoimpl;

import com.dao.ProductDao;
import com.pojo.Product;
import java.sql.*;
import java.util.*;

public class ProductDaoImpl implements ProductDao {
    private Connection getConnection() throws SQLException {
 
        String url = "jdbc:mysql://localhost:3306/furni";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public Product getProductById(int pid) {
        String sql = "SELECT p.*, c.category_name, c.category_description " +
                     "FROM product p JOIN category c ON p.cid = c.cid WHERE p.pid = ?";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, pid);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Product(
                        rs.getInt("pid"),
                        rs.getString("pname"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("image_url"),
                        rs.getInt("cid"),
                        rs.getString("category_name"),
                        rs.getString("category_description")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to get product by ID", e);
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.*, c.category_name, c.category_description " +
                     "FROM product p LEFT JOIN category c ON p.cid = c.cid";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                products.add(new Product(
                    rs.getInt("pid"),
                    rs.getString("pname"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"),
                    rs.getString("image_url"),
                    rs.getInt("cid"),
                    rs.getString("category_name"),
                    rs.getString("category_description")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to get all products", e);
        }
        return products;
    }

    @Override
    public boolean addProduct(Product p) {
        String sql = "INSERT INTO product (pname, description, price, quantity, image_url, cid) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection con = getConnection();
             Statement stmt = con.createStatement()) {
            
            // Disable foreign key checks
            stmt.execute("SET FOREIGN_KEY_CHECKS=0");
            
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, p.getPname());
                ps.setString(2, p.getDescription());
                ps.setDouble(3, p.getPrice());
                ps.setInt(4, p.getQuantity());
                ps.setString(5, p.getImageUrl());
                ps.setInt(6, p.getCid());
                
                return ps.executeUpdate() > 0;
            } finally {
                // Re-enable foreign key checks
                stmt.execute("SET FOREIGN_KEY_CHECKS=1");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add product", e);
        }
    }
   
    @Override
    public boolean updateProduct(Product p) {
        String sql = "UPDATE product SET pname = ?, description = ?, price = ?, " +
                     "quantity = ?, image_url = ?, cid = ? WHERE pid = ?";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, p.getPname());
            ps.setString(2, p.getDescription());
            ps.setDouble(3, p.getPrice());
            ps.setInt(4, p.getQuantity());
            ps.setString(5, p.getImageUrl());
            ps.setInt(6, p.getCid());
            ps.setInt(7, p.getPid());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update product", e);
        }
    }

    @Override
    public boolean deleteProduct(int pid) {
        String sql = "DELETE FROM product WHERE pid = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, pid);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete product", e);
        }
    }

    @Override
    public boolean updateProductQuantity(int pid, int newQty) {
        String sql = "UPDATE product SET quantity = ? WHERE pid = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, newQty);
            ps.setInt(2, pid);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update product quantity", e);
        }
    }

    @Override
    public List<Product> getProductsByCategory(int cid) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.*, c.category_name, c.category_description " +
                     "FROM product p LEFT JOIN category c ON p.cid = c.cid WHERE p.cid = ?";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, cid);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    products.add(new Product(
                        rs.getInt("pid"),
                        rs.getString("pname"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("image_url"),
                        rs.getInt("cid"),
                        rs.getString("category_name"),
                        rs.getString("category_description")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to get products by category", e);
        }
        return products;
    }

    @Override
    public List<Product> searchProductsByName(String pname) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.*, c.category_name, c.category_description " +
                     "FROM product p LEFT JOIN category c ON p.cid = c.cid " +
                     "WHERE p.pname LIKE ?";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, "%" + pname + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    products.add(new Product(
                        rs.getInt("pid"),
                        rs.getString("pname"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("image_url"),
                        rs.getInt("cid"),
                        rs.getString("category_name"),
                        rs.getString("category_description")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to search products by name", e);
        }
        return products;
    }

    @Override
    public List<Product> searchProductsByNameAndCategory(String pname, int cid) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.*, c.category_name, c.category_description " +
                     "FROM product p LEFT JOIN category c ON p.cid = c.cid " +
                     "WHERE p.pname LIKE ? AND p.cid = ?";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, "%" + pname + "%");
            ps.setInt(2, cid);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    products.add(new Product(
                        rs.getInt("pid"),
                        rs.getString("pname"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("image_url"),
                        rs.getInt("cid"),
                        rs.getString("category_name"),
                        rs.getString("category_description")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to search products by name and category", e);
        }
        return products;
    }
}