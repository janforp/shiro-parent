package com.janita.shiro.controller;

import com.janita.shiro.service.ShiroService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Janita on 2017/6/20 0020-下午 3:57
 * 该类是：
 */
@Controller
@RequestMapping("/shiro")
public class AnnotationController {

    @Autowired
    private ShiroService shiroService;

    /**
     * 要求必须有 admin 角色才能访问该方法
     * 但是一般是放在 controller 层
     */
    @RequiresRoles({"admin"})
    @GetMapping("/testShiroAnnotation")
    public String testShiroAnnotation(HttpSession session) {
        session.setAttribute("key", "value123345");
        shiroService.testMethod();
        return "redirect:/shiro/";
    }
}