package com.janita.like.dao;


import com.janita.like.entity.User;

import java.util.List;

/**
 * Created by com.janita.project.MybatisCodeGenerate on 2017-06-21
 */
public interface UserDAO {
    int deleteByPrimaryKey(String userId);

    void insert(User record);

    void insertSelective(User record);

    void insertBatch(List<User> records);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getByLoginName(String loginName);
}