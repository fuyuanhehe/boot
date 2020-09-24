package com.boot.boot.service;

import com.boot.boot.model.User;

public interface UserService {
	
	 /** 根据用户名字获取所有信息 **/
    User getUserByUsername(String username);

    /** 新增用户 **/
    void insertUser(User user);
}
