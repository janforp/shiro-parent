package com.janita.like.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Janita on 2017/6/23 0023-上午 11:48
 * 该类是：
 */
@ConfigurationProperties
public class CustomProperties implements InitializingBean{

    public static long TOKEN_EXPIRE_TIME;

    @Value("${token.expireTime}")
    private long expireTime;


    @Override
    public void afterPropertiesSet() throws Exception {
        TOKEN_EXPIRE_TIME = expireTime;
    }
}
