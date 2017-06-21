package com.janita.project.dao;

import com.janita.project.entity.Role;

import java.util.List;

/**
 * Created by com.janita.project.MybatisCodeGenerate on 2017-06-21
 */
public interface RoleDAO {
    int deleteByPrimaryKey(String roleId);

    void insert(Role record);

    void insertSelective(Role record);

    void insertBatch(List<Role> records);

    Role selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 根据 roleId 列表 查询 对应的 role 列表
     * @param roleIds
     * @return
     */
    List<Role> getRoleListByRoleIdList(List<String> roleIds);
}