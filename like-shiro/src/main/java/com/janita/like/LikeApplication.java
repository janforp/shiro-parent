package com.janita.like;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Janita on 2017/6/21 0021-上午 10:57
 * 该类是：
 */
@SpringBootApplication
@MapperScan(basePackages ="com.janita.project")
public class LikeApplication {
    public static void main(String[] args) {
        SpringApplication.run(LikeApplication.class, args);
    }
}
