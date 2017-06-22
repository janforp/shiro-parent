package com.janita.like.controller;

import com.janita.like.bean.LoginResultBean;
import com.janita.like.entity.User;
import com.janita.like.result.ResultDto;
import com.janita.like.result.ResultDtoFactory;
import com.janita.like.service.LoginService;
import com.janita.like.service.authority.AuthenticationService;
import com.janita.like.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static com.janita.like.util.BeanConvertUtils.convertUserToLoginResultBean;


/**
 * Created by Janita on 2017/6/21 0021-上午 11:40
 * 该类是：
 */
@RestController
public class LoginController {

    private final LoginService loginService;
    private final AuthenticationService authenticationService;

    @Autowired(required = false)
    public LoginController(LoginService loginService, AuthenticationService authenticationService) {
        this.loginService = loginService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResultDto login(@RequestParam("loginName") String loginName, @RequestParam("password") String password) {
        User user = loginService.login(loginName, password);
        Set<String> permissions = authenticationService.getPermissionURLByUserId(user.getUserId());
        LoginResultBean bean = convertUserToLoginResultBean(user, permissions);
        bean.setToken(CommonUtils.getRandomUUID());
        //把该用户的权限存入redis，用于他后面的请求看是否有权限，在拦截器中检查
        authenticationService.saveToCache(bean);
        return ResultDtoFactory.toSuccess(bean);
    }
}
