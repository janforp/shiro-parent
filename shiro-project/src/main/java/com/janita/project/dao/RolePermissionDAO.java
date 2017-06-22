package com.janita.project.dao;

import com.janita.project.entity.RolePermission;

import java.util.List;

/**
 * Created by com.janita.project.MybatisCodeGenerate on 2017-06-21
 */
public interface RolePermissionDAO {
    int deleteByPrimaryKey(String roleId, String permissionId);

    void insert(RolePermission record);

    void insertSelective(RolePermission record);

    void insertBatch(List<RolePermission> records);

    RolePermission selectByPrimaryKey(String roleId, String permissionId);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

    List<RolePermission> getByRoleIdList(List<String> roleIds);

}