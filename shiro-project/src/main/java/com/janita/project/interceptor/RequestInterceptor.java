package com.janita.like.interceptor;

import com.janita.like.config.RedisUtilsTemplate;
import com.janita.like.constant.CommonConsts;
import com.janita.like.enums.ResultEnum;
import com.janita.like.exception.InterceptorException;
import com.janita.like.exception.LoginException;
import com.janita.like.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Janita on 2017/6/2 0002
 * 普通请求的 拦截器
 */
public class RequestInterceptor implements HandlerInterceptor {

    @Value("${ruiZhiTokenExpireSecond}")
    private Long ruiZhiTokenExpireSecond;

    private final RedisUtilsTemplate redisUtilsTemplate;

    @Autowired
    public RequestInterceptor(RedisUtilsTemplate redisUtilsTemplate, Long ruiZhiTokenExpireSecond) {
        this.redisUtilsTemplate = redisUtilsTemplate;
        this.ruiZhiTokenExpireSecond = ruiZhiTokenExpireSecond;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

        String headerToken = request.getHeader(CommonConsts.HEADER_TOKEN);
        if (StringUtils.isEmpty(headerToken)){
            throw new InterceptorException(ResultEnum.HEADER_TOKEN_NAME_EMPTY);
        }
        //去缓存中根据loginName获取到对应的token
        String redisToken = RedisUtils.getObjectOfKey(redisUtilsTemplate,"" + "");
        //若 token 空，或者 与请求头中的不一致，则不通过验证
        if (StringUtils.isEmpty(redisToken) || !headerToken.equals(redisToken)){
            throw new InterceptorException(ResultEnum.WRONG_TOKEN);
        }else {
            RedisUtils.setExpire(redisUtilsTemplate, "" + "", ruiZhiTokenExpireSecond);
            return true;
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {}
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {}
}
