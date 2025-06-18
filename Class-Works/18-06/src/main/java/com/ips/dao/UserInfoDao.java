package com.ips.dao;

import com.ips.pojo.UserInfo;

public interface UserInfoDao {

	UserInfo checkUserCredential(UserInfo u);
	boolean addNewUser(UserInfo u);
}
