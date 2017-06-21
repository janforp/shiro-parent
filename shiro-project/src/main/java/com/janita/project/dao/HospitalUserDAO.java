package com.janita.project.dao;

import com.janita.project.entity.HospitalUser;

import java.util.List;

/**
 * Created by com.janita.project.MybatisCodeGenerate on 2017-06-21
 */
public interface HospitalUserDAO {
    int deleteByPrimaryKey(String userId);

    void insert(HospitalUser record);

    void insertSelective(HospitalUser record);

    void insertBatch(List<HospitalUser> records);

    HospitalUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(HospitalUser record);

    int updateByPrimaryKey(HospitalUser record);

    HospitalUser getByLoginName(String loginName);
}