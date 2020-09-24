package com.boot.boot.service.impl;

import org.springframework.stereotype.Service;

import com.boot.boot.mapper.UserAndRoleMapper;
import com.boot.boot.model.UserAndRole;
import com.boot.boot.service.UserAndRoleService;

import javax.annotation.Resource;

@Service(value = "/userAndRoleService")
public class UserAndRoleServiceImpl implements UserAndRoleService {
    @Resource
    private UserAndRoleMapper userAndRoleDao;

    @Override
    public UserAndRole getUserAndRoleByUsername(String username) {
        UserAndRole userAndRole = userAndRoleDao.getUserAndRoleByUsername(username);
        return userAndRole;
    }
}
