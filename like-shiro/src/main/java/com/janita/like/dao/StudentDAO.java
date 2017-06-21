package com.janita.like.dao;

import com.janita.like.entity.Student;

import java.util.List;

/**
 * Created by com.janita.like.MybatisCodeGenerate on 2017-06-21
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