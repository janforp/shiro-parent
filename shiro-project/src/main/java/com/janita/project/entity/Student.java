package com.janita.project.entity;

/**
 * Created by com.janita.project.MybatisCodeGenerate on 2017-06-21
 */
public class Student implements java.io.Serializable {

    // Fields

    // 主键
    private String studentId;
    // 姓名
    private String name;
    private String address;

    // Constructors

    /**
     * default constructor
     */
    public Student() {
    }

    /**
     * full constructor
     */
    public Student(String studentId, String name, String address) {
        this.studentId = studentId;
        this.name = name;
        this.address = address;
    }

    // Property accessors

    /**
     * 主键
     */
    public String getStudentId() {
        return this.studentId;
    }

    /**
     * 主键
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * 姓名
     */
    public String getName() {
        return this.name;
    }

    /**
     * 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}