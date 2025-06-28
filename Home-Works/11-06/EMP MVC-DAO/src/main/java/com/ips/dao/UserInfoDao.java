package com.ips.dao;

import java.util.List;

import com.ips.pojo.UserInfo;

public interface UserInfoDao {
	boolean checkUserCredential(UserInfo u);
	boolean registerUser(UserInfo u);
	boolean addUser(UserInfo u);
	boolean updateUser(UserInfo u);
	boolean deleteUser(UserInfo u);
	UserInfo searchUser(int empid); 
	List<UserInfo> getAllEmployee();
	
}
