package com.janita.shiro.realm;

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
 * Created by Janita on 2017/6/20 0020-下午 6:19
 * 该类是：
 */
public class CustomRealmTest {


    @Test
    public void testCustomRealmTest() {
        //创建 SecurityManager 工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realms.ini");
        //创建 SecurityManager
        SecurityManager securityManager = factory.getInstance();
        //将 SecurityManager 设置到系统运行环境
        SecurityUtils.setSecurityManager(securityManager);
        //创建对象
        Subject subject = SecurityUtils.getSubject();
        //创建 token 令牌
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "111111");
        //执行认证
        try {
            subject.login(token);
        }catch (AuthenticationException e) {
            e.printStackTrace();
        }
        System.out.println("\n***** 认证状态 : " + subject.isAuthenticated());
        //认证通过后，执行授权

        //基于资源的授权
        //isPermitted传入权限标识符
        boolean permitted = subject.isPermitted("user:create:1");
        System.out.println("\n***** 单个权限的判断 : " +  permitted);

        boolean permittedAll = subject.isPermittedAll("user:create:1", "user:update");
        System.out.println("\n***** 多个权限 判断:" + permittedAll);
    }
}
