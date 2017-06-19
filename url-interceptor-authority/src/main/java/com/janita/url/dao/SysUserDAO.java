package com.janita.url.dao;

import com.janita.url.entity.SysUser;

import java.util.List;

/**
 * Created by com.janita.url.MybatisCodeGenerate on 2017-06-19
 */
public interface SysUserDAO {
    int deleteByPrimaryKey(String id);

    void insert(SysUser record);

    void insertSelective(SysUser record);

    void insertBatch(List<SysUser> records);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    //TODO
    List<SysUser> findSysUserByUserCode(String userCode);
}