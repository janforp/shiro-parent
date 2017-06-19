package com.janita.url.service;


import com.janita.url.entity.SysUser;
import com.janita.url.po.ActiveUser;

/**
 * Created by Janita on 2017/6/19 0019-下午 7:51
 * 该类是：登录
 */
public interface ISysService {

    /**
     * 登录验证
     * @param userCode  登录账号
     * @param password  密码
     * @return  对象
     */
    ActiveUser authenticate(String userCode, String password);

    SysUser findSysUserByUserCode(String userCode);
    
}
