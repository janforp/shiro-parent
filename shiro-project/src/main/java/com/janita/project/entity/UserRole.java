package com.janita.project.entity;

/**
 * Created by com.janita.project.MybatisCodeGenerate on 2017-06-21
 */
public class UserRole implements java.io.Serializable {

    // Fields

    private String userId;
    private String roleId;

    // Constructors

    /**
     * default constructor
     */
    public UserRole() {
    }

    /**
     * full constructor
     */
    public UserRole(String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    // Property accessors

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}