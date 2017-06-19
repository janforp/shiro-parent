package com.janita.url.dao;

import com.janita.url.entity.SysPermission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Janita on 2017/6/19 0019-下午 6:36
 * 该类是：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysPermissionDAOTest {

    @Autowired
    private SysPermissionDAO sysPermissionDAO;

    @Test
    public void selectByPrimaryKey() throws Exception {
        SysPermission sysPermission = sysPermissionDAO.selectByPrimaryKey(14L);

        System.out.println("\n***** : " + sysPermission.getName());
    }

}