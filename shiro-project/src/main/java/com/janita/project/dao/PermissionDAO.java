package com.janita.project.dao;

import com.janita.project.entity.Permission;

import java.util.List;

/**
 * Created by com.janita.project.MybatisCodeGenerate on 2017-06-21
 */
public interface PermissionDAO {
    int deleteByPrimaryKey(String permissionId);

    void insert(Permission record);

    void insertSelective(Permission record);

    void insertBatch(List<Permission> records);

    Permission selectByPrimaryKey(String permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<Permission> getByPermissionIdList(List<String> permissionIds);
}