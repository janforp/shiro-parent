package com.janita.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Janita on 2017/6/20 0020-下午 3:00
 * 该类是：没有权限的时候跳转的接口
 */
@Controller
@RequestMapping("/unauthorized")
public class UnauthorizedController {

    @GetMapping
    public String toUnauthorizedPage() {
        return "unauthorized";
    }
}
