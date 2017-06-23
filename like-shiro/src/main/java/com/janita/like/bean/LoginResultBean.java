package com.janita.like.bean;

import java.util.List;

/**
 * Created by Janita on 2017/6/21 0021-下午 4:24
 * 该类是：
 */
public class LoginResultBean {

    private String token;
    // 主键
    private String userId;
    // 账号
    private String loginName;
    // 姓名
    private String username;

    private List<String> permissions;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "LoginResultBean{" +
                "token='" + token + '\'' +
                ", userId='" + userId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", username='" + username + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
