package com.boot.boot.service;

import com.boot.boot.model.UserAndRole;

public interface UserAndRoleService {

	
	/** 根据用户名字获取角色 **/
    UserAndRole getUserAndRoleByUsername(String username);
}
