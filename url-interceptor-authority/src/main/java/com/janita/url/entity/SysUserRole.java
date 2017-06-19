package com.janita.url.entity;

/**
 * Created by com.janita.url.MybatisCodeGenerate on 2017-06-19
 */
public class SysUserRole implements java.io.Serializable {

    // Fields

    private String id;
    private String sysUserId;
    private String sysRoleId;

    // Constructors

    /**
     * default constructor
     */
    public SysUserRole() {
    }

    /**
     * full constructor
     */
    public SysUserRole(String id, String sysUserId, String sysRoleId) {
        this.id = id;
        this.sysUserId = sysUserId;
        this.sysRoleId = sysRoleId;
    }

    // Property accessors

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSysUserId() {
        return this.sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getSysRoleId() {
        return this.sysRoleId;
    }

    public void setSysRoleId(String sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

}