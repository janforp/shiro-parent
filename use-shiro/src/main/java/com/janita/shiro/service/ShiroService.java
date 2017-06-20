package com.janita.shiro.service;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Janita on 2017/6/20 0020-下午 3:36
 * 该类是：
 */
@Service
public class ShiroService {

    /**
     * 要求必须有 admin 角色才能访问该方法
     */
    @RequiresRoles({"admin"})
    public void testMethod() {
        System.out.println("\n***** : " + "testMethod： " + new Date());
    }
}
