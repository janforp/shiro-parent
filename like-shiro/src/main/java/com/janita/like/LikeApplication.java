package com.janita.like;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Janita on 2017/6/21 0021-上午 10:57
 * 该类是：不适用 shiro 框架，自己实现权限
 * 基本原理：
 * 1.登录之后对每个登录成功的用户生成一个 uuid 的 token,并获取该用户所有的 permission
 * 2.把 token 及其他的基本数据传到前端
 * 3.后面的请求每次都需要带上次 token
 * 4.在拦截器中获取 token 对应的 permission ,比较本次请求的 URL 是否包括在 permission 中
 * 5.若包括，则表示该用户可以请求，若不包括，则表示没有该权限
 */
@SpringBootApplication
@MapperScan(basePackages ="com.janita.like")
public class LikeApplication {
    public static void main(String[] args) {
        SpringApplication.run(LikeApplication.class, args);
    }
}
