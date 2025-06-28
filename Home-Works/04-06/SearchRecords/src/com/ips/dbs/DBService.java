package com.ips.dbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ips.pojo.Employee;

public class DBService {
	Connection con;

	public DBService() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ips?user=root&password=root");
		} 
		catch (ClassNotFoundException e) {
			System.err.println("error in loading drivers");
		}
		catch(SQLException e) {
			System.err.println("error in sql query");
		}
	}
	
	
	public Employee SearchEmployee(Employee emp) {
		Employee em=new Employee();
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from Employee where empid=?");
			ps.setInt(1, emp.getEmpid());
			ResultSet rs=ps.executeQuery();
			if(rs.next()==true) {
				em.setEmpid(rs.getInt("empid"));
				em.setEmpname(rs.getString("empname"));
				em.setSalary(rs.getDouble("salary"));
				return em;
				
			}
			else {
				return null;
			}
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
			return null;
		}
	}

}
