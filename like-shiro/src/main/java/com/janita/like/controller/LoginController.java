package com.janita.like.controller;

import com.janita.like.bean.LoginResultBean;
import com.janita.like.entity.User;
import com.janita.like.result.ResultDto;
import com.janita.like.result.ResultDtoFactory;
import com.janita.like.service.LoginService;
import com.janita.like.service.authority.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Janita on 2017/6/21 0021-上午 11:40
 * 该类是：
 */
@RestController
public class LoginController {

    private final LoginService loginService;
    private final AuthorityService authorityService;

    @Autowired(required = false)
    public LoginController(LoginService loginService, AuthorityService authorityService) {
        this.loginService = loginService;
        this.authorityService = authorityService;
    }

    @PostMapping("/login")
    public ResultDto login(@RequestParam("loginName") String loginName, @RequestParam("password") String password) {
        User user = loginService.login(loginName, password);
        LoginResultBean bean = new LoginResultBean();
        bean.setUsername(user.getUsername());
        return ResultDtoFactory.toSuccess(bean);
    }
}
