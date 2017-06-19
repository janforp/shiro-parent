package com.janita.url.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Janita on 2017/6/16 0016-下午 1:51
 * 该类是：
 */
@Controller
public class HelloController {

    /**
     * 跳转到 hello.html
     * @param map   带参到页面
     * @return  视图名称
     */
    @RequestMapping("/hello")
    public String helloHtml(Map<String, Object> map) {
        map.put("hello", "我是来自HelloController#helloHtml的参数");
        return "hello";
    }
}
