package com.janita.project.controller;

import com.janita.project.exception.CustomException;
import com.janita.project.result.ResultDto;
import com.janita.project.result.ResultDtoFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Janita on 2017/6/21 0021-上午 11:40
 * 该类是：
 */
@RestController
public class LoginController {

    @PostMapping("/login")
    public ResultDto login(@RequestParam("loginName") String loginName, @RequestParam("password") String password) {
        Subject currentUser = SecurityUtils.getSubject();
        if (! currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
            token.setRememberMe(true);
            try {
                //会到 LoginRealm 中认证
                currentUser.login(token);
            }catch (AuthenticationException e) {
                e.printStackTrace();
                throw new CustomException("登录失败");
            }
        }
        return ResultDtoFactory.toSuccess();
    }

    @GetMapping("/logout")
    public ResultDto logout(){
        return ResultDtoFactory.toSuccess("登出成功");
    }
}
