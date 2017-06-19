package com.janita.url.dao;

import com.janita.url.entity.SysUserRole;

import java.util.List;

/**
 * Created by com.janita.url.MybatisCodeGenerate on 2017-06-19
 */
public interface SysUserRoleDAO {
    int deleteByPrimaryKey(String id);

    void insert(SysUserRole record);

    void insertSelective(SysUserRole record);

    void insertBatch(List<SysUserRole> records);

    SysUserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
}