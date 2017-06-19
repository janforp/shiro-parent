package com.janita.url.entity;

/**
 * Created by com.janita.url.MybatisCodeGenerate on 2017-06-19
 */
public class SysUser implements java.io.Serializable {

    // Fields

    // 主键
    private String id;
    // 账号
    private String usercode;
    // 姓名
    private String username;
    // 密码
    private String password;
    // 盐
    private String salt;
    // 账号是否锁定，1：锁定，0未锁定
    private String locked;

    // Constructors

    /**
     * default constructor
     */
    public SysUser() {
    }

    /**
     * full constructor
     */
    public SysUser(String id, String usercode, String username, String password, String salt, String locked) {
        this.id = id;
        this.usercode = usercode;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.locked = locked;
    }

    // Property accessors

    /**
     * 主键
     */
    public String getId() {
        return this.id;
    }

    /**
     * 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 账号
     */
    public String getUsercode() {
        return this.usercode;
    }

    /**
     * 账号
     */
    public void setUsercode(String usercode) {
        this.usercode = usercode;
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
    public String getLocked() {
        return this.locked;
    }

    /**
     * 账号是否锁定，1：锁定，0未锁定
     */
    public void setLocked(String locked) {
        this.locked = locked;
    }

}