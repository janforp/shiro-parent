package com.janita.project.service;

import com.janita.project.entity.User;
import com.janita.project.service.base.UserService;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Janita on 2017/6/21 0021-下午 3:36
 * 该类是：
 */
@Service
public class LoginService {

    private final UserService userService;

    @Autowired
    public LoginService(UserService userService) {
        this.userService = userService;
    }

    public User login(UsernamePasswordToken token){
        String loginName = token.getUsername();
        return userService.getByLoginName(loginName);
    }
}
