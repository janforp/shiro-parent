package com.janita.like.config;

import com.janita.like.interceptor.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Janita on 2017/6/2 0002
 * 拦截器配置
 */
@Configuration
@SuppressWarnings("unused")
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Autowired(required = false)
    private RedisUtilsTemplate redisUtilsTemplate;

    @Value("${ruiZhiTokenExpireSecond}")
    private Long ruiZhiTokenExpireSecond;

    /**
     * 多个拦截器组成一个拦截器链
     * addPathPatterns 用于添加拦截规则
     * excludePathPatterns 用户排除拦截
     * @param registry  注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new RequestInterceptor(redisUtilsTemplate, ruiZhiTokenExpireSecond)).addPathPatterns("/other/**");
        super.addInterceptors(registry);
    }
}
