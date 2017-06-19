package com.janita.url.controller;

import com.janita.url.service.ISysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Janita on 2017/6/19 0019-下午 7:48
 * 该类是：用于登录
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private ISysService loginService;

    @GetMapping("/")
    public String toLoginPage() {
        return "login";
    }
}
