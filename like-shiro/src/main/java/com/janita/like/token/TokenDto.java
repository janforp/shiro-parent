package com.janita.like.token;

import java.io.Serializable;

/**
 * Created by Janita on 2017-03-28 16:14
 * token 实体类
 */
public class TokenDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String loginName;
    private Long tokenTime;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Long getTokenTime() {
        return tokenTime;
    }

    public void setTokenTime(Long tokenTime) {
        this.tokenTime = tokenTime;
    }

    @Override
    public String toString() {
        return "TokenDto{" +
                "loginName='" + loginName + '\'' +
                ", tokenTime=" + tokenTime +
                '}';
    }
}
