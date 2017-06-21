package com.janita.like.service;

import com.janita.like.entity.*;
import com.janita.like.service.base.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static com.janita.like.util.AuthenticationUtils.*;

/**
 * Created by Janita on 2017/6/21 0021-上午 11:56
 * 该类是：认证相关服务
 */
@Service
public class AuthenticationService {

    private final UserService userService;
    private final RoleService roleService;
    private final UserRoleService userRoleService;
    private final PermissionService permissionService;
    private final RolePermissionService rolePermissionService;

    @Autowired
    public AuthenticationService(UserService userService, RoleService roleService, UserRoleService userRoleService, PermissionService permissionService, RolePermissionService rolePermissionService) {
        this.userService = userService;
        this.roleService = roleService;
        this.userRoleService = userRoleService;
        this.permissionService = permissionService;
        this.rolePermissionService = rolePermissionService;
    }

    /**
     * 根据 loginName 查询
     * @param loginName
     * @return
     */
    public HospitalUser getUserByLoginName(String loginName) {
        return userService.getByLoginName(loginName);
    }

    /**
     * 根据用户的id查询出该用户的所有角色名
     * @param userId
     * @return
     */
    public Set<String> getRoleNameByUserId(String userId) {
        List<UserRole> userRoleList = userRoleService.getByUserId(userId);
        List<String> roleIds = getRoleIdByList(userRoleList);
        List<Role> roleList = roleService.getRoleListByRoleIdList(roleIds);
        return getRoleNameByList(roleList);
    }

    /**
     *
     * @param userId
     * @return
     */
    public Set<String> getPermissionNameByUserId(String userId) {
        List<UserRole> userRoleList = userRoleService.getByUserId(userId);
        List<String> roleIds = getRoleIdByList(userRoleList);
        List<RolePermission> rolePermissionList = rolePermissionService.getByRoleIdList(roleIds);
        List<String> permissionIds = getPermissionIdInList(rolePermissionList);
        List<Permission> permissionList = permissionService.getByPermissionIdList(permissionIds);
        return getPermissionCodeInList(permissionList);
    }
}
