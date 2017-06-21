package com.janita.like.entity;

/**
 * Created by com.janita.like.MybatisCodeGenerate on 2017-06-21
 */
public class RolePermission implements java.io.Serializable {

    // Fields

    // 角色id
    private String roleId;
    // 权限id
    private String permissionId;

    // Constructors

    /**
     * default constructor
     */
    public RolePermission() {
    }

    /**
     * full constructor
     */
    public RolePermission(String roleId, String permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
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

    /**
     * 权限id
     */
    public String getPermissionId() {
        return this.permissionId;
    }

    /**
     * 权限id
     */
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

}