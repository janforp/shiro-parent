package com.janita.like.service.base;

import com.janita.like.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Janita on 2017/6/21 0021-下午 1:44
 * 该类是：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {
    @Autowired
    private RoleService roleService;

    @Test
    public void getRoleListByRoleIdList() throws Exception {

        List<Role> roleListByRoleIdList = roleService.getRoleListByRoleIdList(Arrays.asList("1", "2"));
        System.out.println("\n***** : " + roleListByRoleIdList);
    }

}