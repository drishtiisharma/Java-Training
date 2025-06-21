package com.dao;

import java.util.List;

import com.pojo.UserInfo;

public interface dao {
    boolean addUser(UserInfo u);
    boolean updateUser(UserInfo u);
    boolean deleteUser(String email);
    UserInfo getUserByLoginCredential(String credential, String password);
    List<UserInfo> getAllUsers();
    boolean isUsernameExists(String username);
    boolean isEmailExists(String email);
}