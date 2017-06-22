package com.janita.project.controller;

import com.janita.project.bean.LoginResultBean;
import com.janita.project.config.RedisUtilsTemplate;
import com.janita.project.entity.HospitalUser;
import com.janita.project.result.ResultDto;
import com.janita.project.result.ResultDtoFactory;
import com.janita.project.service.LoginService;
import com.janita.project.service.SessionService;
import com.janita.project.util.RedisUtils;
import com.janita.project.util.SessionSerializableUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Janita on 2017/6/21 0021-上午 11:40
 * 该类是：
 * 前后端分离时 shiro 的使用原理：
 * 1.登录之后获取该用户的角色/权限信息，用户基本信息
 * 2.把他们存入 session 中
 * 3.把该 session 的 id 返回给前端
 * 4.之后的请求需要带上次 sessionId ，后台调用接口之前先看是否有权限
 */
@RestController
public class LoginController {

    private final LoginService loginService;
    private final SessionService sessionService;
    private final RedisUtilsTemplate redisUtilsTemplate;

    @Autowired(required = false)
    public LoginController(LoginService loginService, SessionService sessionService, RedisUtilsTemplate redisUtilsTemplate) {
        this.loginService = loginService;
        this.sessionService = sessionService;
        this.redisUtilsTemplate = redisUtilsTemplate;
    }

    @PostMapping("/login")
    public ResultDto login(@RequestParam("loginName") String loginName, @RequestParam("password") String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
        token.setRememberMe(true);
        subject.login(token);
        Session session = sessionService.createAndConfigSession(subject, token);
//        RedisUtils.setKeyOfObject(redisUtilsTemplate,"session", session);
        HospitalUser user = loginService.login(token);
        LoginResultBean bean = new LoginResultBean();
        bean.setSessionId(session.getId().toString());
        bean.setUsername(user.getUsername());
        return ResultDtoFactory.toSuccess(bean);
    }

    @GetMapping("/logout")
    public ResultDto logout(){
        return ResultDtoFactory.toSuccess("登出成功");
    }
}
