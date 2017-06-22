package com.janita.project.shiro.realm;

import com.janita.project.entity.HospitalUser;
import com.janita.project.service.AuthenticationService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * Created by Janita on 2017/6/20 0020-上午 9:34
 * 该类是：
 * 认证的 realm
 */
public class LoginRealm extends AuthorizingRealm {

    @Autowired
    private AuthenticationService authenticationService;

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String loginName = usernamePasswordToken.getUsername();
        HospitalUser user = authenticationService.getUserByLoginName(loginName);
        String userId = user.getUserId();
        String password = user.getPassword();
        ByteSource salt = ByteSource.Util.bytes(user.getSalt());
        return new SimpleAuthenticationInfo(userId, password, salt, getName());
    }

    /**
     * 授权方法
     * @param principals
     * @return user登录只能服务 user,而 admin 登录可以访问2个
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //1. 从 PrincipalCollection 中获取登录用户的信息
        Object primaryPrincipal = principals.getPrimaryPrincipal();
        String userId = (String) primaryPrincipal;
        //根据该 userId 查询出该用户的 角色 跟权限
        Set<String> roles = authenticationService.getRoleNameByUserId(userId);
        System.out.println("\n***** : " + roles);
        Set<String> permissions = authenticationService.getPermissionNameByUserId(userId);
        System.out.println("\n***** : " + permissions);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);
        //4.返回 SimpleAuthorization 对象
        return info;
    }
}
