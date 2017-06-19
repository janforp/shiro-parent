package com.janita.url.dao;

import com.janita.url.entity.SysRolePermission;

import java.util.List;

/**
 * Created by com.janita.url.MybatisCodeGenerate on 2017-06-19
 */
public interface SysRolePermissionDAO {
    int deleteByPrimaryKey(String id);

    void insert(SysRolePermission record);

    void insertSelective(SysRolePermission record);

    void insertBatch(List<SysRolePermission> records);

    SysRolePermission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);
}