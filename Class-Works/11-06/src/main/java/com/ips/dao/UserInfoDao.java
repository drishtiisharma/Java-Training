package com.ips.dao;

import com.ips.pojo.UserInfo;

public interface UserInfoDao {

	boolean checkUserCredential(UserInfo u);
	boolean addNewUser(UserInfo u);
}
