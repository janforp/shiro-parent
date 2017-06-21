package com.janita.project.controller;

import com.janita.project.entity.HospitalUser;
import com.janita.project.result.ResultDto;
import com.janita.project.result.ResultDtoFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Janita on 2017/6/21 0021-上午 11:40
 * 该类是：
 */
@RestController
public class LoginController {

    @PostMapping("/login")
    public ResultDto login(@RequestParam("loginName") String loginName, @RequestParam("password") String password) {
        Subject subject = SecurityUtils.getSubject();
        if (! subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
            token.setRememberMe(true);
            subject.login(token);
        }
        return ResultDtoFactory.toSuccess();
    }

    @GetMapping("/logout")
    public ResultDto logout(){
        return ResultDtoFactory.toSuccess("登出成功");
    }


//    @ResponseBody
//    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
//    public String login2(
//            @RequestParam(required = false) String username,
//            @RequestParam(required = false) String password
//    ) {
//        JSONObject jsonObject = new JSONObject();
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        try {
//            // 登录，即身份验证
//            subject.login(token);
//            sessionManager.addOnlineSession(subject.getSession().getId());
//            HospitalUser user = userService.getUserByLoginName(token.getUsername());
//            // 在session中存放用户信息
//            subject.getSession().setAttribute("userLogin", user);
//            jsonObject.put("error", 0);
//            jsonObject.put("msg", "登录成功");
//            // 返回sessionId作为token
//            jsonObject.put("token",subject.getSession().getId());
//        } catch (IncorrectCredentialsException e) {
//            throw new JsonException("用户名或密码错误", 405);
//        } catch (LockedAccountException e) {
//            throw new JsonException("登录失败，该用户已被冻结", 405);
//        } catch (AuthenticationException e) {
//            throw new JsonException("用户名或密码错误", 405);
//        }
//        return jsonObject.toString();
//    }
}
