package com.janita.project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Janita on 2017/3/14.
 * redis配置
 */
@Configuration
@SuppressWarnings("unused")
public class RedisConfig {

    @Value("${spring.redis.database}")
    private int database;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.port}")
    private Integer port;

    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.pool.min-idle}")
    private int minIdle;

    @Value("${spring.redis.pool.max-active}")
    private int maxActive;

    @Value("${spring.redis.pool.max-wait}")
    private int maxWait;

    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(host);
        jedisConnectionFactory.setPassword(password);
        jedisConnectionFactory.setPort(port);
        jedisConnectionFactory.setDatabase(database);
        jedisConnectionFactory.setUsePool(true);
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);

        return jedisConnectionFactory;
    }

    /**
     * 注入的是自己封装的redis模板
     * @return
     */
    @Bean(name = "redisUtilsTemplate")
    public RedisUtilsTemplate redisTemplate(){
        RedisUtilsTemplate redisTemplate = new RedisUtilsTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

}
