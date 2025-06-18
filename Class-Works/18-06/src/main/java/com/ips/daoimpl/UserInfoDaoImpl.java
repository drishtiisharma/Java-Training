package com.ips.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.catalina.User;

import com.ips.dao.UserInfoDao;
import com.ips.pojo.UserInfo;

public class UserInfoDaoImpl implements UserInfoDao{

	Connection con=null;
	public UserInfoDaoImpl()
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
	public UserInfo checkUserCredential(UserInfo u) {
		
		UserInfo user = new UserInfo();
		try {
		PreparedStatement ps = con.prepareStatement("select * "
				+ "from user where username = ? and password = ?");
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getPassword());
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()==true)
		{
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setRole(rs.getString("role"));
			user.setDp(rs.getString("dp"));
			System.out.println(user);
		}
		else
			return null;
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		return user;
	}
	@Override
	public boolean addNewUser(UserInfo u) {
		try {
			PreparedStatement ps = con.prepareStatement("insert "
					+ "into customer values(?,?,?,?,?)");
			
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFname());
			ps.setString(4, u.getLname());
			ps.setString(5, u.getContact());
			
			int x = ps.executeUpdate();
			if(x>0)
				{
				ps = con.prepareStatement("insert into user values(?,?,?,?)");
				ps.setString(1, u.getUsername());
				ps.setString(2, u.getPassword());
				ps.setString(3, "Customer");
				ps.setString(4, u.getDp());
				
				x = ps.executeUpdate();
				if(x>0)
				{
					return true;
				}
				else
				{
					return false;
				}
				}
			else
				return false;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
}
