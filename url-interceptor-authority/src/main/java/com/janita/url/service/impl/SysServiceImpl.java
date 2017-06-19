package com.janita.url.service.impl;

import com.janita.url.dao.SysUserDAO;
import com.janita.url.entity.SysUser;
import com.janita.url.exception.CustomException;
import com.janita.url.po.ActiveUser;
import com.janita.url.service.ISysService;
import com.janita.url.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Janita on 2017/6/19 0019-下午 7:58
 * 该类是：
 */
@Service
public class SysServiceImpl implements ISysService {

    private final SysUserDAO sysUserDAO;

    @Autowired(required = false)
    public SysServiceImpl(SysUserDAO sysUserDAO) {
        this.sysUserDAO = sysUserDAO;
    }

    /**
     * 登录验证
     * @param userCode  登录账号
     * @param password  密码
     * @return  对象
     */
    @Override
    public ActiveUser authenticate(String userCode, String password) {
        SysUser sysUser = this.findSysUserByUserCode(userCode);
        if (sysUser == null) {
            throw new CustomException("用户账号不存在");
        }
        String passwordDb = sysUser.getPassword();
        String passwordInputMd5 = new MD5().getMD5ofStr(password);
        if (! passwordDb.equals(passwordInputMd5)) {
            throw new CustomException("用户名或密码错误");
        }

        //认正通过
        ActiveUser activeUser = new ActiveUser();
        activeUser.setUserid(sysUser.getId());
        activeUser.setUsercode(sysUser.getUsercode());
        activeUser.setUsername(sysUser.getUsername());
        return activeUser;
    }


    /**
     * 根据用户账号查询用户信息
     * @param userCode  账号
     * @return  账户对象
     */
    @Override
    public SysUser findSysUserByUserCode(String userCode) {
        List<SysUser> list = sysUserDAO.findSysUserByUserCode(userCode);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

}
