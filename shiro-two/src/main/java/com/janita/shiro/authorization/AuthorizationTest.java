package com.janita.shiro.authorization;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Janita on 2017/6/20 0020-下午 5:39
 * 该类是：授权测试
 */
public class AuthorizationTest {


    @Test
    public void testAuthorization() {
        //创建 SecurityManager 工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-permission.ini");
        //创建 SecurityManager
        SecurityManager securityManager = factory.getInstance();
        //将 SecurityManager 设置到系统运行环境
        SecurityUtils.setSecurityManager(securityManager);
        //创建对象
        Subject subject = SecurityUtils.getSubject();
        //创建 com.janita.like.token 令牌
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123");
        //执行认证
        try {
            subject.login(token);
        }catch (AuthenticationException e) {
            e.printStackTrace();
        }
        System.out.println("\n***** 认证状态 : " + subject.isAuthenticated());
        //认证通过后，执行授权

        //基于角色的授权
        //hasRole传入角色表示
        boolean hasRole = subject.hasRole("role12");
        System.out.println("\n***** 是否有单个角色 : " +  hasRole);
        //是否拥有多个角色
        boolean hasAllRoles = subject.hasAllRoles(Arrays.asList("role1", "role2"));
        System.out.println("\n***** 是否有多个角色 : " + hasAllRoles);

        //若用该方法，若不通过，则抛出异常
        subject.checkRole("role2");

        //基于资源的授权
        //isPermitted传入权限标识符
        boolean permitted = subject.isPermitted("user:create:1");
        System.out.println("\n***** 单个权限的判断 : " +  permitted);

        boolean permittedAll = subject.isPermittedAll("user:create:1", "user:update");
        System.out.println("\n***** 多个权限 判断:" + permittedAll);

        subject.checkPermission("user:delete:1");
    }
}
