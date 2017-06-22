package com.janita.project.dao;

import com.janita.project.entity.Student;

import java.util.List;

/**
 * Created by com.janita.project.MybatisCodeGenerate on 2017-06-21
 */
public interface StudentDAO {
    int deleteByPrimaryKey(String studentId);

    void insert(Student record);

    void insertSelective(Student record);

    void insertBatch(List<Student> records);

    Student selectByPrimaryKey(String studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}