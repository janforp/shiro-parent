package com.janita.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Janita on 2017/6/20 0020-上午 9:20
 * 该类是：
 */
@Controller
@RequestMapping("/shiro")
public class LoginController {



    /**
     * 跳转到登录页面
     * @return
     */
    @GetMapping
    public String toLoginPage() {
        return "login";
    }


    /**
     * 登录操作
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {

        Subject currentUser = SecurityUtils.getSubject();
        if (! currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            try {
                //会传到 realm 实现类中
                currentUser.login(token);
            }catch (AuthenticationException e) {
                e.printStackTrace();
                System.out.println("\n***** : " + "登录失败");
                throw new RuntimeException("登录失败");
            }
        }
        return "redirect:/list";
    }

    /**
     * 登出
     * @return
     */
    @GetMapping("/logout")
    public String logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "logout";
    }
}
