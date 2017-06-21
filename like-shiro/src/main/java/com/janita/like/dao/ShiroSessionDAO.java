package com.janita.like.dao;

import com.janita.like.entity.ShiroSession;

import java.util.List;

/**
 * Created by com.janita.like.MybatisCodeGenerate on 2017-06-21
 */
public interface ShiroSessionDAO {
    int deleteByPrimaryKey(String sessionId);

    void insert(ShiroSession record);

    void insertSelective(ShiroSession record);

    void insertBatch(List<ShiroSession> records);

    ShiroSession selectByPrimaryKey(String sessionId);

    int updateByPrimaryKeySelective(ShiroSession record);

    int updateByPrimaryKey(ShiroSession record);
}