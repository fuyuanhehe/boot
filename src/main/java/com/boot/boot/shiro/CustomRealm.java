package com.boot.boot.shiro;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.boot.boot.model.RoleAndPermission;
import com.boot.boot.model.User;
import com.boot.boot.model.UserAndRole;
import com.boot.boot.service.RoleAndPermissionService;
import com.boot.boot.service.UserAndRoleService;
import com.boot.boot.service.UserService;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;
    @Resource
    private UserAndRoleService userAndRoleService;
    @Resource
    private RoleAndPermissionService roleAndPermissionService;

    
    /** 重写方法实现根据用户名字获取角色菜单 **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    	
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        
        UserAndRole userAndRole = userAndRoleService.getUserAndRoleByUsername(username);
        
        if (userAndRole != null) {
            String roles=userAndRole.getRoleName();
            String[] role=roles.split(",");
            Set<String> roleSet = new HashSet<>();
            Set<String> permissionset = new HashSet<>();
            for (String r:role) {
                roleSet.add(r);
                RoleAndPermission roleAndPermission = roleAndPermissionService.getPermissionByRolename(r);
                String permissions =roleAndPermission.getPermission();
                String[] permission =permissions.split(",");
                for (String per:permission) {
                    permissionset.add(per);
                }
            }
            info.setRoles(roleSet);
            info.setStringPermissions(permissionset);

            return info;
        }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        User user = userService.getUserByUsername(username);
        if (user != null) {
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,user.getPassword(),this.getName());
            info.setCredentialsSalt(ByteSource.Util.bytes(username));
            return info;
        }
        return null;
    }
}
