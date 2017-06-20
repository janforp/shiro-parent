package com.janita.shiro.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
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
     * 但是一般是放在 controller 层
     */
//    @RequiresRoles({"admin"})
    public void testMethod() {
        System.out.println("\n***** : " + "testMethod： " + new Date());
        //HttpSession 与 shiro 的 session 可以转化
        Session session = SecurityUtils.getSubject().getSession();
        System.out.println("\n***** session 的属性值 : " + session.getAttribute("key"));
    }
}
