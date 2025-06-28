package com.ips.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	public boolean checkUserCredential(UserInfo u) {
		
		try {
		PreparedStatement ps = con.prepareStatement("select * "
				+ "from userinfo where username = ? and password = ?");
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getPassword());
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()==true)
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
	public boolean addNewUser(UserInfo u) {
		try {
			PreparedStatement ps = con.prepareStatement("insert "
					+ "into userinfo values(?,?)");
			
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			
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
	
}
