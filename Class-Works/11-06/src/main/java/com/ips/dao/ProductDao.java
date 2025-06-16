package com.ips.dao;

import java.util.List;

import com.ips.pojo.Product;

public interface ProductDao {

	boolean addProduct(Product p);
	boolean updateProduct(Product p);
	boolean deleteProduct(Product p);
	Product searchProduct(int pid);
	List<Product> getAllProduct();
	
}
