package com.janita.url.interceptor;

import com.janita.url.po.ActiveUser;
import com.janita.url.util.ResourcesUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Janita on 2017/6/19 0019-下午 8:26
 * 该类是：
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 校验用户访问是否是公开资源地址(无需认证即可访问)
        List<String> open_urls = ResourcesUtil.gekeyList("anonymousURL");
        // 用户访问的url
        String url = request.getRequestURI();
        for (String open_url : open_urls) {
            if (url.contains(open_url)) {
                // 如果访问的是公开 地址则放行
                return true;
            }
        }

        // 校验用户身份是否认证通过
        HttpSession session = request.getSession();
        ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
        if (activeUser != null) {
            // 用户已经登陆认证，放行
            return true;
        }
        // 跳转到登陆页面
        request.getRequestDispatcher("/login").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
