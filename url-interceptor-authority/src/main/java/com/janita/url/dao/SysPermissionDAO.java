package com.janita.url.dao;

import com.janita.url.entity.SysPermission;

import java.util.List;

/**
 * Created by com.janita.url.MybatisCodeGenerate on 2017-06-19
 */
public interface SysPermissionDAO {
    int deleteByPrimaryKey(Long id);

    void insert(SysPermission record);

    void insertSelective(SysPermission record);

    void insertBatch(List<SysPermission> records);

    SysPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
}