package com.janita.url.entity;

/**
 * Created by com.janita.url.MybatisCodeGenerate on 2017-06-19
 */
public class SysRole implements java.io.Serializable {

    // Fields

    private String id;
    private String name;
    // 是否可用,1：可用，0不可用
    private String available;

    // Constructors

    /**
     * default constructor
     */
    public SysRole() {
    }

    /**
     * full constructor
     */
    public SysRole(String id, String name, String available) {
        this.id = id;
        this.name = name;
        this.available = available;
    }

    // Property accessors

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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