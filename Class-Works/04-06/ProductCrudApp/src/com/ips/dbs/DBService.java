package com.ips.dbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ips.pojo.Product;

public class DBService {

	Connection con =null;
	public DBService() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
				+ "ips25java?user=root&password=root");
		}
		catch (Exception e) 
		{
			System.out.println("Error in loading drivers and making connection");
		}
	}
	
	public boolean addProduct(Product p)
	{
		try 
		{
			PreparedStatement ps = 
				con.prepareStatement("insert into product values(?,?,?)");
			ps.setInt(1, p.getpId());
			ps.setString(2, p.getpName());
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

	public boolean updateProduct(Product p)
	{
		try 
		{
			PreparedStatement ps = 
				con.prepareStatement("update product set pname = ?,"
						+ "price = ? where pid = ?");
			ps.setString(1, p.getpName());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getpId());
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
	public boolean deleteProduct(Product p)
	{
		try 
		{
			PreparedStatement ps = 
			con.prepareStatement("delete from product where pid = ?");
			ps.setInt(1, p.getpId());
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
	public Product searchProduct(Product p)
	{
		Product pd = new Product();
		try 
		{
			PreparedStatement ps = 
			con.prepareStatement("select * from product where pid = ?");
			ps.setInt(1, p.getpId());
			ResultSet rs = ps.executeQuery();
			if(rs.next()==true)
			{
				pd.setpId(rs.getInt("pid"));
				pd.setpName(rs.getString("pname"));
				pd.setPrice(rs.getDouble("price"));
				return pd;
			}
			else
				return null;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Product> getAllProduct()
	{
		ArrayList<Product>lst = new ArrayList<>();
		try 
		{
			PreparedStatement ps = 
			con.prepareStatement("select * from product");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Product pd = new Product();
				pd.setpId(rs.getInt("pid"));
				pd.setpName(rs.getString("pname"));
				pd.setPrice(rs.getDouble("price"));
				
				lst.add(pd);
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
