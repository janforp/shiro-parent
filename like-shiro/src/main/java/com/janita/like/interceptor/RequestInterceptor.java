package com.janita.like.interceptor;

import com.janita.like.config.RedisUtilsTemplate;
import com.janita.like.constant.CommonConsts;
import com.janita.like.entity.Permission;
import com.janita.like.enums.ResultEnum;
import com.janita.like.exception.CustomException;
import com.janita.like.exception.InterceptorException;
import com.janita.like.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Janita on 2017/6/2 0002
 * 普通请求的 拦截器
 */
public class RequestInterceptor implements HandlerInterceptor {

    private RedisUtilsTemplate redisUtilsTemplate;

    @Autowired
    public RequestInterceptor(RedisUtilsTemplate redisUtilsTemplate) {
        this.redisUtilsTemplate = redisUtilsTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

        String headerToken = request.getHeader(CommonConsts.HEADER_TOKEN);
        if (StringUtils.isEmpty(headerToken)){
            throw new InterceptorException(ResultEnum.HEADER_TOKEN_NAME_EMPTY);
        }
        //去缓存中根据loginName获取到对应的token
        List<Permission> permissions = RedisUtils.getObjectOfKey(redisUtilsTemplate, headerToken);
        System.out.println("\n***** 该用户具有的权限 : " +  permissions);

        String requestURI = request.getRequestURI();
        System.out.println("\n***** 本次请求资源 : " + requestURI);
        if (permissions.contains(requestURI)) {
            return true;
        }
        throw new CustomException(ResultEnum.AUTHORITY_NOT_ENOUGH);
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {}
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {}
}
