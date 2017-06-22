package com.janita.project.service;

import com.janita.project.entity.User;
import com.janita.project.service.base.UserService;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Janita on 2017/6/21 0021-下午 4:19
 * 该类是：
 */
@Service
public class SessionService {

    @Autowired
    private UserService userService;

    /**
     * 生成 Session 并且 设置属性
     * @param subject
     * @param token
     * @return
     */
    public Session createAndConfigSession(Subject subject, UsernamePasswordToken token) {
        Session session = subject.getSession();
        String loginName = token.getUsername();
        User user = userService.getByLoginName(loginName);
        session.setAttribute("user", user);
        return session;
    }
}
