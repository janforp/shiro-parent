package com.janita.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janita on 2017/6/20 0020-下午 6:03
 * 该类是：
 */
public class CustomRealm extends AuthorizingRealm {

    /**
     * 认证
     * @param token 令牌
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String userCode = (String) token.getPrincipal();
        String password = "111111";
        return new SimpleAuthenticationInfo(userCode, password, this.getName());
    }

    /**
     * 授权
     * @param principals    身份
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //主身份信息，需要转换为真实的身份信息
        Object primaryPrincipal = principals.getPrimaryPrincipal();
        //将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
        String userCode = (String) primaryPrincipal;

        //在这里是需要从数据库查询的
        List<String> permissions = new ArrayList<>();
        permissions.add("user:create");//用户的创建
        permissions.add("items:add");//商品添加权限

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }
}
