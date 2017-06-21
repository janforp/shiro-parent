package com.janita.project.dao;

import com.janita.project.entity.UserRole;

import java.util.List;

/**
 * Created by com.janita.project.MybatisCodeGenerate on 2017-06-21
 */
public interface UserRoleDAO {
    int deleteByPrimaryKey(String userId, String roleId);

    void insert(UserRole record);

    void insertSelective(UserRole record);

    void insertBatch(List<UserRole> records);

    UserRole selectByPrimaryKey(String userId, String roleId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    /**
     * 根据 userId 查询出该用户的所有角色
     * @param userId
     * @return
     */
    List<UserRole> getByUserId(String userId);
}