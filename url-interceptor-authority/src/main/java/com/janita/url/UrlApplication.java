package com.janita.url;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Janita on 2017/6/19 0019-下午 5:44
 * 该类是：基于 url 的权限管理
 */
@SpringBootApplication
@MapperScan(basePackages ="com.janita.url")
public class UrlApplication {
    public static void main(String[] args) {
        SpringApplication.run(UrlApplication.class, args);
    }
}
