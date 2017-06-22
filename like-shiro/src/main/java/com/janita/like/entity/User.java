package com.janita.like.entity;

/**
 * Created by com.janita.project.MybatisCodeGenerate on 2017-06-21
 */
public class User implements java.io.Serializable {

    // Fields

    // 主键
    private String userId;
    // 账号
    private String loginName;
    // 姓名
    private String username;
    // 密码
    private String password;
    // 盐
    private String salt;
    // 账号是否锁定，1：锁定，0未锁定
    private Integer locked;

    // Constructors

    /**
     * default constructor
     */
    public User() {
    }

    /**
     * full constructor
     */
    public User(String userId, String loginName, String username, String password, String salt, Integer locked) {
        this.userId = userId;
        this.loginName = loginName;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.locked = locked;
    }

    // Property accessors

    /**
     * 主键
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * 主键
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 账号
     */
    public String getLoginName() {
        return this.loginName;
    }

    /**
     * 账号
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 姓名
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * 姓名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 密码
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 盐
     */
    public String getSalt() {
        return this.salt;
    }

    /**
     * 盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 账号是否锁定，1：锁定，0未锁定
     */
    public Integer getLocked() {
        return this.locked;
    }

    /**
     * 账号是否锁定，1：锁定，0未锁定
     */
    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", locked=" + locked +
                '}';
    }
}