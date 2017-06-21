package com.janita.like.entity;

/**
 * Created by com.janita.like.MybatisCodeGenerate on 2017-06-21
 */
public class Role implements java.io.Serializable {

    // Fields

    // 角色id
    private String roleId;
    private String roleName;
    // 是否可用,1：可用，0不可用
    private Integer available;

    // Constructors

    /**
     * default constructor
     */
    public Role() {
    }

    /**
     * full constructor
     */
    public Role(String roleId, String roleName, Integer available) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.available = available;
    }

    // Property accessors

    /**
     * 角色id
     */
    public String getRoleId() {
        return this.roleId;
    }

    /**
     * 角色id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 是否可用,1：可用，0不可用
     */
    public Integer getAvailable() {
        return this.available;
    }

    /**
     * 是否可用,1：可用，0不可用
     */
    public void setAvailable(Integer available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", available=" + available +
                '}';
    }
}