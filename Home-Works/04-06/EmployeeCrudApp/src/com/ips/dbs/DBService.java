package com.ips.dbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ips.pojo.Employee;

public class DBService {

	Connection con;
	public DBService() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
				+ "ips?user=root&password=root");
		}
		catch (Exception e) 
		{
			System.out.println("Error in loading drivers and making connection");
		}
	}
	
	public boolean addEmployee(Employee p)
	{
		try 
		{
			PreparedStatement ps =	con.prepareStatement("insert into Employee values(?,?,?)");
			ps.setInt(1, p.getEmpid());
			ps.setString(2, p.getEmpname());
			ps.setDouble(3, p.getSalary());
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

	public boolean updateEmployee(Employee p)
	{
		try 
		{
			PreparedStatement ps = 
				con.prepareStatement("update Employee set empname = ? , salary = ? where empid = ?");
			ps.setString(1, p.getEmpname());
			ps.setDouble(2, p.getSalary());
			ps.setInt(3, p.getEmpid());
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
	public boolean deleteEmployee(Employee p)
	{
		try 
		{
			PreparedStatement ps = 
			con.prepareStatement("delete from Employee where empid = ?");
			ps.setInt(1, p.getEmpid());
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
	public Employee searchEmployee(Employee p)
	{
		Employee pd = new Employee();
		try 
		{
			PreparedStatement ps = con.prepareStatement("select * from Employee where empid = ?");
			ps.setInt(1, p.getEmpid());
			ResultSet rs = ps.executeQuery();
			if(rs.next()==true)
			{
				pd.setEmpid(rs.getInt("empid"));
				pd.setEmpname(rs.getString("empname"));
				pd.setSalary(rs.getDouble("salary"));
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
	public ArrayList<Employee> getAllEmployee()
	{
		ArrayList<Employee>lst = new ArrayList<>();
		try 
		{
			PreparedStatement ps = 
			con.prepareStatement("select * from Employee");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Employee pd = new Employee();
				pd.setEmpid(rs.getInt("empid"));
				pd.setEmpname(rs.getString("empname"));
				pd.setSalary(rs.getDouble("salary"));
				
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
