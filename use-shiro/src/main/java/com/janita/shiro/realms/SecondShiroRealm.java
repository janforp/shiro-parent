package com.janita.shiro.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

/**
 * Created by Janita on 2017/6/20 0020-上午 9:34
 * 该类是：认证的 realm
 */
public class SecondShiroRealm extends AuthenticatingRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("\n***** : " + "第二个 realm");


        //1.强转为 UsernamePasswordToken
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        //2.从 UsernamePasswordToken 中取到 username
        String username = usernamePasswordToken.getUsername();
        //3.从数据库中查询记录
        System.out.println("\n***** : " + "从数据库中获取username: " + username + ", 所对应的用户信息");
        //4.若不存在，则抛出 UnknownAccountException
        if ("unknown".equals(username)) {
            throw new UnknownAccountException("用户不存在");
        }
        //5.根据用户信息情况，决定抛出其他异常
        if ("monster".equals(username)) {
            throw new LockedAccountException("用户被锁定");
        }
        //6.构造返回对象
        //以下信息是从数据库中获取的

        //principal:认证的实体信息，可以是 username, 也可以是实体对象
        Object principal = username;
        //密码
        Object credentials = null;
        if ("admin".equals(username)){
            credentials = "ce2f6417c7e1d32c1d81a797ee0b499f87c5de06";
        }else if ("user".equals(username)){
            credentials = "073d4c3ae812935f23cb3f2a71943f49e082a718";
        }
        //realmName
        String realmName = getName();
        //盐值
        ByteSource salt = ByteSource.Util.bytes(username);
        return new SimpleAuthenticationInfo("secondRealmName", credentials, salt, realmName);
    }

    public static void main(String[] args) {
        String name = "SHA1";
        Object cre = "123456";
        int time = 1024;
        ByteSource salt = ByteSource.Util.bytes("admin");
        Object res = new SimpleHash(name, cre, salt, time);
        System.out.println("\n***** : " + res);
    }
}
