package com.boot.boot.service.impl;

import com.boot.boot.mapper.UserMapper;
import com.boot.boot.model.User;
import com.boot.boot.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Override
    public PageInfo findPage(Map map) {
        int pageNum = Integer.valueOf(map.get("pageNum").toString());
        int pageSize = Integer.valueOf(map.get("pageSize").toString());
        PageHelper.startPage(pageNum, pageSize);
        List<User> sysMenus = userDao.getUserList(map);
        return new PageInfo<>(sysMenus);
    }
}
