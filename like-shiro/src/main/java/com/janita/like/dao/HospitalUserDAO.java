package com.janita.like.dao;

import com.janita.like.entity.HospitalUser;

import java.util.List;

/**
 * Created by com.janita.like.MybatisCodeGenerate on 2017-06-21
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