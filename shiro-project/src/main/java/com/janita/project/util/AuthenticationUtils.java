package com.janita.project.util;

import com.janita.project.entity.Permission;
import com.janita.project.entity.Role;
import com.janita.project.entity.RolePermission;
import com.janita.project.entity.UserRole;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Janita on 2017/6/21 0021-下午 12:50
 * 该类是：
 */
public class AuthenticationUtils {


    /**
     * 获取列表中的所有的 roleId
     * @param userRoleList
     * @return
     */
    public static List<String> getRoleIdByList(List<UserRole> userRoleList) {
        List<String> roleIds = null ;
        if (!userRoleList.isEmpty()) {
            roleIds = new ArrayList<>();
            for (UserRole userRole : userRoleList) {
                roleIds.add(userRole.getRoleId());
            }
        }
        return roleIds;
    }

    /**
     *
     * @param roleList
     * @return
     */
    public static Set<String> getRoleNameByList(List<Role> roleList) {
        Set<String> set = null ;
        if (!roleList.isEmpty()) {
            set = roleList.stream().map(Role::getRoleName).collect(Collectors.toSet());
        }
        return set;
    }

    public static List<String> getPermissionIdInList(List<RolePermission> rolePermissionList) {
        List<String> list = null;
        if (!rolePermissionList.isEmpty()) {
            list = rolePermissionList.stream().map(RolePermission::getPermissionId).collect(Collectors.toList());
        }
        return list;
    }

    public static Set<String> getPermissionCodeInList(List<Permission> permissionList){
        if (!permissionList.isEmpty()) {
            return permissionList.stream().map(Permission::getPermissionCode).collect(Collectors.toSet());
        }
        return null;
    }

}
