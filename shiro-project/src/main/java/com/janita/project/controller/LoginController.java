package com.janita.project.controller;

import com.janita.project.entity.HospitalUser;
import com.janita.project.result.ResultDto;
import com.janita.project.result.ResultDtoFactory;
import com.janita.project.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Janita on 2017/6/21 0021-上午 11:40
 * 该类是：
 */
@RestController
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResultDto login(@RequestParam("loginName") String loginName, @RequestParam("password") String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
        token.setRememberMe(true);
        subject.login(token);
        HospitalUser user = loginService.login(token);
        return ResultDtoFactory.toSuccess(user);
    }

    @GetMapping("/logout")
    public ResultDto logout(){
        return ResultDtoFactory.toSuccess("登出成功");
    }
}
