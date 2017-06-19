package com.janita.url.entity;

/**
 * Created by com.janita.url.MybatisCodeGenerate on 2017-06-19
 */
public class SysRolePermission implements java.io.Serializable {

    // Fields

    private String id;
    // 角色id
    private String sysRoleId;
    // 权限id
    private String sysPermissionId;

    // Constructors

    /**
     * default constructor
     */
    public SysRolePermission() {
    }

    /**
     * full constructor
     */
    public SysRolePermission(String id, String sysRoleId, String sysPermissionId) {
        this.id = id;
        this.sysRoleId = sysRoleId;
        this.sysPermissionId = sysPermissionId;
    }

    // Property accessors

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 角色id
     */
    public String getSysRoleId() {
        return this.sysRoleId;
    }

    /**
     * 角色id
     */
    public void setSysRoleId(String sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    /**
     * 权限id
     */
    public String getSysPermissionId() {
        return this.sysPermissionId;
    }

    /**
     * 权限id
     */
    public void setSysPermissionId(String sysPermissionId) {
        this.sysPermissionId = sysPermissionId;
    }

}