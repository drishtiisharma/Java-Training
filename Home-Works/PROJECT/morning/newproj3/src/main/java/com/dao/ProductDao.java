package com.dao;

import com.pojo.Product;
import java.util.List;

public interface ProductDao {
    Product getProductById(int pid);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(int cid);
    boolean deleteProduct(int pid);
    boolean updateProductQuantity(int pid, int newQty);
    boolean addProduct(Product p);
    boolean updateProduct(Product p);
    List<Product> searchProductsByName(String pname);
    List<Product> searchProductsByNameAndCategory(String pname, int cid);
}