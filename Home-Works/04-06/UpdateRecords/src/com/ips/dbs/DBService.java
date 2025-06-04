package com.ips.dbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	
	public boolean addEmployee(Employee emp) {
		try {
			PreparedStatement ps=con.prepareStatement("update employee set empname=?, salary=? where empid=?");
			ps.setString(1, emp.getEmpname());
			ps.setDouble(2, emp.getSalary());
			ps.setInt(3, emp.getEmpid());
			int x=ps.executeUpdate();
			if(x>0) {
				return true;
			}
			else {
				return false;
			}
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
			return false;
		}
	}

}
