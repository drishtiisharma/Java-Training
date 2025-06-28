package com.ips.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ips.dao.UserInfoDao;
import com.ips.pojo.UserInfo;

public class UserInfoDaoImpl implements UserInfoDao {
	
	Connection con=null;

	public UserInfoDaoImpl() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ips?user=root&password=root");
		}
		catch(Exception e) {
			System.err.println("error in loading drivers or making connection!");
		}
	}

	@Override
	public boolean checkUserCredential(UserInfo u) {
	
		try {
			PreparedStatement ps=con.prepareStatement("select * from employee where empid=? and password=?");
			ps.setInt(1, u.getEmpid());
			ps.setString(2, u.getPassword());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()==true) {
				return true;		
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean registerUser(UserInfo u) {
		
		try {
			PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?,?,?)");
			ps.setInt(1, u.getEmpid());
			ps.setString(2, u.getEmpname());
			ps.setString(3, u.getPassword());
			ps.setDouble(4, u.getSalary());
			ps.setString(5, u.getDesignation());
			ps.setString(6, u.getDepartment());
			
			int x=ps.executeUpdate();
			if(x>0) {
				return true;
			}
			else {
				return false;
			}
				
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean addUser(UserInfo u) {
		
		try {
			PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?,?,?)");
			ps.setInt(1, u.getEmpid());
			ps.setString(2, u.getEmpname());
			ps.setString(3, u.getPassword());
			ps.setDouble(4, u.getSalary());
			ps.setString(5, u.getDesignation());
			ps.setString(6, u.getDepartment());
			
			int x=ps.executeUpdate();
			if(x>0) {
				return true;
			}
			else {
				return false;
			}
				
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUser(UserInfo u) {
		try {
			PreparedStatement ps=con.prepareStatement("update employee set empname=?, password=?, salary=?, designation=?, department=? where empid=?");
	
			ps.setString(1, u.getEmpname());
			ps.setString(2, u.getPassword());
			ps.setDouble(3, u.getSalary());
			ps.setString(4, u.getDesignation());
			ps.setString(5, u.getDepartment());
			ps.setInt(6, u.getEmpid());
			
			int x=ps.executeUpdate();
			if(x>0) {
				return true;
			}
			else {
				return false;
			}
				
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean deleteUser(UserInfo u) {
		try {
			PreparedStatement ps=con.prepareStatement("delete from employee where empid=?");
			ps.setInt(1, u.getEmpid());
			
			int x=ps.executeUpdate();
			if(x>0) {
				return true;
			}
			else {
				return false;
			}
				
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public UserInfo searchUser(int empid) {
		UserInfo ui=new UserInfo();
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from employee where empid=?");
			ps.setInt(1, empid);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()==true) {
				ui.setEmpid(rs.getInt("empid"));
				ui.setEmpname(rs.getString("empname"));
				ui.setSalary(rs.getDouble("salary"));
				ui.setDesignation(rs.getString("designation"));
				ui.setDepartment(rs.getString("department"));
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return ui;

		
		
	}

	@Override
	public List<UserInfo> getAllEmployee() {
		List<UserInfo>lst=new ArrayList<UserInfo>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from employee");			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				UserInfo ue=new UserInfo();
				ue.setEmpid(rs.getInt("empid"));
				ue.setEmpname(rs.getString("empname"));
				ue.setSalary(rs.getDouble("salary"));
				ue.setDesignation(rs.getString("designation"));
				ue.setDepartment(rs.getString("department"));
				
				lst.add(ue);
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
			
		}
		return lst;
		
	}

	

	
}
