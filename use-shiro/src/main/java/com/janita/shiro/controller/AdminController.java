package com.janita.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Janita on 2017/6/20 0020-下午 2:55
 * 该类是：
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String toAdminPage() {
        return "admin";
    }
}
