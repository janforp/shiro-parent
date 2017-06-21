package com.janita.project.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Janita on 2017/6/21 0021-下午 1:37
 * 该类是：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthenticationServiceTest {
    @Autowired
    private AuthenticationService authenticationService;


    @Test
    public void getUserByLoginName() throws Exception {

    }

    @Test
    public void getRoleNameByUserId() throws Exception {
        Set<String> roleNameByUserId = authenticationService.getRoleNameByUserId("1");
        System.out.println("\n***** : " +  roleNameByUserId);
    }

    @Test
    public void getPermissionNameByUserId() throws Exception {
        Set<String> roleNameByUserId = authenticationService.getPermissionNameByUserId("1");
        System.out.println("\n***** : " + roleNameByUserId);
    }

}