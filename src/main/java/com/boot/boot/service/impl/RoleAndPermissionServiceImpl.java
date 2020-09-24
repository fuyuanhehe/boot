package com.boot.boot.service.impl;

import org.springframework.stereotype.Service;

import com.boot.boot.mapper.RoleAndPermissionMapper;
import com.boot.boot.model.RoleAndPermission;
import com.boot.boot.service.RoleAndPermissionService;

import javax.annotation.Resource;

@Service(value = "/roleAndPermissionService")
public class RoleAndPermissionServiceImpl implements RoleAndPermissionService {
    @Resource
    private RoleAndPermissionMapper roleAndPermissionDao;

    public RoleAndPermission getPermissionByRolename(String rolename){
        return roleAndPermissionDao.getPermissionByRolename(rolename);
    }
}
