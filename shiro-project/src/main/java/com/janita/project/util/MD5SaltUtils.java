package com.janita.project.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by Janita on 2017/6/21 0021-下午 1:58
 * 该类是：
 */
public class MD5SaltUtils {

    public static String getSaltPassword(String password) {
        String name = "MD5";
        Object cre = password;
        int time = 1024;
        ByteSource salt = ByteSource.Util.bytes("123");
        Object res = new SimpleHash(name, cre, salt, time);

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println("\n***** : " +         getSaltPassword("123456"));
    }
}
