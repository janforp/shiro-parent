package com.janita.url.dao;

import com.janita.url.entity.SysRole;

import java.util.List;

/**
 * Created by com.janita.url.MybatisCodeGenerate on 2017-06-19
 */
public interface SysRoleDAO {
    int deleteByPrimaryKey(String id);

    void insert(SysRole record);

    void insertSelective(SysRole record);

    void insertBatch(List<SysRole> records);

    SysRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}