package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBService 
{
Connection con=null;
	public DBService() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ips25java?user=root&password=root");
		}
		catch (Exception e) 
		{
			System.out.println("Error in loading drive or meking connection");
		}
	}
	public boolean check(UserInfo u)
	{
		boolean isvalid=false;
		try 
		{
	PreparedStatement ps = con.prepareStatement("select * from "
			+ "userinfo where username = ? and password = ?");
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getPassword());
		ResultSet rs = ps.executeQuery();
		if(rs.next()==true)
		{
			isvalid=true;
		}
		else
		{
			isvalid=false;
		}
		}
		catch (Exception e) 
		{
		
		}
		return isvalid;
	}
	
	public int addToCart(Product p)
	{
		int x=0;
		try 
		{
		PreparedStatement ps = con.prepareStatement("insert into"
				+ " prd values(?,?,?)");
		ps.setString(1, p.getPid());
		ps.setInt(2, p.getPrice());
		ps.setString(3, p.getUsername());
		
		x = ps.executeUpdate();
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return x;
	}
	
	public ArrayList getCart(String user)
	{
		ArrayList al = new ArrayList();
		try 
		{
		PreparedStatement ps = con.prepareStatement("select "
				+ "* from prd where username = ?");
		ps.setString(1, user);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			Product p = new Product();
			p.setPid(rs.getString("pid"));
			p.setPrice(rs.getInt("price"));
			p.setUsername(rs.getString("username"));
			al.add(p);
		}
		
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return al;
	}
	/*public int modifyStudent(Student s)
	{
		int x=0;
		try 
		{
		PreparedStatement ps = con.prepareStatement("update students set name = ?,marks = ? where roll = ?");
		
		ps.setString(1, s.getName());
		ps.setInt(2, s.getMarks());
		ps.setInt(3, s.getRoll());
		x = ps.executeUpdate();
		}
		catch (Exception e) 
		{
		
		}
		return x;
	}
	public int deleteStudent(Student s)
	{
		int x=0;
		try 
		{
		PreparedStatement ps = con.prepareStatement("delete from students where roll = ?");
		
		ps.setInt(1, s.getRoll());
		x = ps.executeUpdate();
		}
		catch (Exception e) 
		{
		
		}
		return x;
	}
	public ArrayList getAllStudents()
	{
		ArrayList al = new ArrayList();
		try 
		{
		PreparedStatement ps = con.prepareStatement("select * from students");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			Student s = new Student();
			s.setRoll(rs.getInt("roll"));
			s.setName(rs.getString("name"));
			s.setMarks(rs.getInt("marks"));
			al.add(s);
		}
		
		}
		catch (Exception e) 
		{
		
		}
		return al;
	}*/
	
}
