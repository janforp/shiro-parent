package com.janita.url.entity;

/**
 * Created by com.janita.url.MybatisCodeGenerate on 2017-06-19
 */
public class SysPermission implements java.io.Serializable {

    // Fields

    // 主键
    private Long id;
    // 资源名称
    private String name;
    // 资源类型：menu,button,
    private String type;
    // 访问url地址
    private String url;
    // 权限代码字符串
    private String percode;
    // 父结点id
    private Long parentid;
    // 父结点id列表串
    private String parentids;
    // 排序号
    private String sortstring;
    // 是否可用,1：可用，0不可用
    private String available;

    // Constructors

    /**
     * default constructor
     */
    public SysPermission() {
    }

    /**
     * full constructor
     */
    public SysPermission(Long id, String name, String type, String url, String percode, Long parentid, String parentids, String sortstring, String available) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.url = url;
        this.percode = percode;
        this.parentid = parentid;
        this.parentids = parentids;
        this.sortstring = sortstring;
        this.available = available;
    }

    // Property accessors

    /**
     * 主键
     */
    public Long getId() {
        return this.id;
    }

    /**
     * 主键
     */
    public void setId(Long id) {
        this.id = id;
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
    public String getPercode() {
        return this.percode;
    }

    /**
     * 权限代码字符串
     */
    public void setPercode(String percode) {
        this.percode = percode;
    }

    /**
     * 父结点id
     */
    public Long getParentid() {
        return this.parentid;
    }

    /**
     * 父结点id
     */
    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    /**
     * 父结点id列表串
     */
    public String getParentids() {
        return this.parentids;
    }

    /**
     * 父结点id列表串
     */
    public void setParentids(String parentids) {
        this.parentids = parentids;
    }

    /**
     * 排序号
     */
    public String getSortstring() {
        return this.sortstring;
    }

    /**
     * 排序号
     */
    public void setSortstring(String sortstring) {
        this.sortstring = sortstring;
    }

    /**
     * 是否可用,1：可用，0不可用
     */
    public String getAvailable() {
        return this.available;
    }

    /**
     * 是否可用,1：可用，0不可用
     */
    public void setAvailable(String available) {
        this.available = available;
    }

}