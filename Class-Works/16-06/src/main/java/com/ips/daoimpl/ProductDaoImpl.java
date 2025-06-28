package com.ips.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ips.dao.ProductDao;
import com.ips.pojo.Product;

public class ProductDaoImpl implements ProductDao
{

	Connection con = null;
	public ProductDaoImpl() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ips25java?user=root&password=root");
		}
		catch (Exception e) 
		{
			System.out.println("Error in loading drivers or making connection");
		}
	}
	@Override
	public boolean addProduct(Product p) 
	{
		try 
		{
			PreparedStatement ps = con.prepareStatement("insert "
			+ "into product values(?,?,?)");
			ps.setInt(1, p.getPid());
			ps.setString(2, p.getPname());
			ps.setDouble(3, p.getPrice());
			int x = ps.executeUpdate();
			if(x>0)
				return true;
			else
				return false;
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean updateProduct(Product p) {
		try 
		{
			PreparedStatement ps = con.prepareStatement("update "
			+ "product set pname = ?,price = ? where pid = ?");
			
			ps.setString(1, p.getPname());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getPid());
			int x = ps.executeUpdate();
			if(x>0)
				return true;
			else
				return false;
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	
	}
	@Override
	public boolean deleteProduct(Product p) {
		try 
		{
			PreparedStatement ps = con.prepareStatement("delete "
			+ " from product where pid = ?");
			
			ps.setInt(1, p.getPid());
			int x = ps.executeUpdate();
			if(x>0)
				return true;
			else
				return false;
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	
	}
	@Override
	public Product searchProduct(int pid) {
		Product p = new Product();
		try 
		{
			PreparedStatement ps = con.prepareStatement("select "
				+ "* from product where pid = ?");
			ps.setInt(1, pid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()==true)
			{
				
				p.setPid(rs.getInt("pid"));
				p.setPname(rs.getString("pname"));
				p.setPrice(rs.getDouble("price"));
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		return p;
	}
	@Override
	public List<Product> getAllProduct() {
		List<Product>lst = new ArrayList<>();
		try 
		{
			PreparedStatement ps = con.prepareStatement("select "
					+ "* from product");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Product p = new Product();
				p.setPid(rs.getInt("pid"));
				p.setPname(rs.getString("pname"));
				p.setPrice(rs.getDouble("price"));
				
				lst.add(p);
			}
			
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		return lst;
	}
}
