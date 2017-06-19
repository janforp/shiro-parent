package com.janita.url.controller;

import com.janita.url.exception.CustomException;
import com.janita.url.po.ActiveUser;
import com.janita.url.service.ISysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

/**
 * Created by Janita on 2017/6/19 0019-下午 7:48
 * 该类是：用于登录
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private final ISysService sysService;

    @Autowired
    public LoginController(ISysService sysService) {
        this.sysService = sysService;
    }

    @GetMapping("/")
    public String toLoginPage() {
        return "login";
    }

    /**
     * 登录
     * @param session
     * @param userCode
     * @param password
     * @return
     */
    @PostMapping("/login")
    public String login(HttpSession session, String userCode, String password, String randomCode) {
        //校验验证码
        String validateCode = (String) session.getAttribute("validateCode");
        if (validateCode.equals(randomCode)) {
            throw new CustomException("验证码输入错误");
        }
        ActiveUser activeUser = sysService.authenticate(userCode, password);
        session.setAttribute("activeUser", activeUser);
        return "redirect:/first.action";
    }

    /**
     * 退出
     * @param httpSession
     * @return
     * @throws Exception
     */
    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) throws Exception{
        //清空session
        httpSession.invalidate();
        return "redirect:/first.action";
    }
}
