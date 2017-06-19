package com.janita.url.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Janita on 2017/6/19 0019-下午 8:20
 * 该类是：
 */
@Controller
public class FirstPageController {

    //系统首页
    @GetMapping("/first")
    public String first() {
        return "first";
    }

    //欢迎页面
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
