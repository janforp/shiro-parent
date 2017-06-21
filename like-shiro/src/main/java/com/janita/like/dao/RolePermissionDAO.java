package com.janita.like.dao;

import com.janita.like.entity.RolePermission;

import java.util.List;

/**
 * Created by com.janita.like.MybatisCodeGenerate on 2017-06-21
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