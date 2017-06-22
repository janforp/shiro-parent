package com.janita.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Janita on 2017/6/22 0022-下午 2:01
 * 该类是：
 */
@EnableAutoConfiguration
@ComponentScan
@Configuration
public class BootShiroApplication {

//    public static void main(String... args) {
//        new SpringApplicationBuilder()
//                .sources(BootShiroApplication.class)
//                .showBanner(false)
//                .run(args);
//    }

    public static void main(String... args) {
        SpringApplication.run(BootShiroApplication.class, args);
    }
}
