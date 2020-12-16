package com.boot.boot.service;

import com.boot.boot.model.User;
import com.github.pagehelper.PageInfo;

import java.util.Map;


public interface UserService {
	
	 /** 根据用户名字获取所有信息 **/
    User getUserByUsername(String username);

    /** 新增用户 **/
    void insertUser(User user);


    PageInfo<User> findPage(Map map);

}
