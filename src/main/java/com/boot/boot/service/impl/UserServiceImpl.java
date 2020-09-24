package com.boot.boot.service.impl;

import org.springframework.stereotype.Service;

import com.boot.boot.mapper.UserMapper;
import com.boot.boot.model.User;
import com.boot.boot.service.UserService;

import javax.annotation.Resource;

@Service(value = "/userService")
public class UserServiceImpl implements UserService {
	
    @Resource
    UserMapper userDao;
    
    
    /** 根据用户名获取用户信息 **/
    @Override
    public User getUserByUsername(String username) {
        User user = userDao.getUserByUsername(username);
        return user;
    }

    /** 新增用户 **/
    @Override
    public void insertUser(User user) {
        userDao.insert(user);
    }
}
