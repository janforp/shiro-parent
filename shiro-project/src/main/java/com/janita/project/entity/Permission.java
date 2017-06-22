package com.janita.project.entity;

/**
 * Created by com.janita.project.MybatisCodeGenerate on 2017-06-21
 */
public class Permission implements java.io.Serializable {

    // Fields

    // 主键
    private String permissionId;
    // 资源名称
    private String name;
    // 资源类型：menu,button,
    private String type;
    // 访问url地址
    private String url;
    // 权限代码字符串
    private String permissionCode;
    // 父结点id
    private Long parentId;
    // 父结点id列表串
    private String parentIds;
    // 排序号
    private String sortString;
    // 是否可用,1：可用，0不可用
    private Integer available;

    // Constructors

    /**
     * default constructor
     */
    public Permission() {
    }

    /**
     * full constructor
     */
    public Permission(String permissionId, String name, String type, String url, String permissionCode, Long parentId, String parentIds, String sortString, Integer available) {
        this.permissionId = permissionId;
        this.name = name;
        this.type = type;
        this.url = url;
        this.permissionCode = permissionCode;
        this.parentId = parentId;
        this.parentIds = parentIds;
        this.sortString = sortString;
        this.available = available;
    }

    // Property accessors

    /**
     * 主键
     */
    public String getPermissionId() {
        return this.permissionId;
    }

    /**
     * 主键
     */
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * 资源名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 资源名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 资源类型：menu,button,
     */
    public String getType() {
        return this.type;
    }

    /**
     * 资源类型：menu,button,
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 访问url地址
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * 访问url地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 权限代码字符串
     */
    public String getPermissionCode() {
        return this.permissionCode;
    }

    /**
     * 权限代码字符串
     */
    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    /**
     * 父结点id
     */
    public Long getParentId() {
        return this.parentId;
    }

    /**
     * 父结点id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 父结点id列表串
     */
    public String getParentIds() {
        return this.parentIds;
    }

    /**
     * 父结点id列表串
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    /**
     * 排序号
     */
    public String getSortString() {
        return this.sortString;
    }

    /**
     * 排序号
     */
    public void setSortString(String sortString) {
        this.sortString = sortString;
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
        return "Permission{" +
                "permissionId='" + permissionId + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", permissionCode='" + permissionCode + '\'' +
                ", parentId=" + parentId +
                ", parentIds='" + parentIds + '\'' +
                ", sortString='" + sortString + '\'' +
                ", available=" + available +
                '}';
    }
}