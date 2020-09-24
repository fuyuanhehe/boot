package com.boot.boot.service;

import com.boot.boot.model.RoleAndPermission;

public interface RoleAndPermissionService {
	
	
	/** 根据角色名字获取菜单 **/
    RoleAndPermission getPermissionByRolename(String rolename);
}
