package com.janita.like.service.authority;

import com.janita.like.bean.LoginResultBean;
import com.janita.like.config.RedisUtilsTemplate;
import com.janita.like.entity.*;
import com.janita.like.service.base.*;
import com.janita.like.util.RedisUtils;
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
    private final RedisUtilsTemplate redisUtilsTemplate;

    @Autowired
    public AuthenticationService(UserService userService,
                                 RoleService roleService,
                                 UserRoleService userRoleService,
                                 PermissionService permissionService,
                                 RolePermissionService rolePermissionService,
                                 RedisUtilsTemplate redisUtilsTemplate) {

        this.userService = userService;
        this.roleService = roleService;
        this.userRoleService = userRoleService;
        this.permissionService = permissionService;
        this.rolePermissionService = rolePermissionService;
        this.redisUtilsTemplate = redisUtilsTemplate;
    }

    /**
     * 根据 loginName 查询
     * @param loginName
     * @return
     */
    public User getUserByLoginName(String loginName) {
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
    public Set<String> getPermissionURLByUserId(String userId) {
        List<UserRole> userRoleList = userRoleService.getByUserId(userId);
        List<String> roleIds = getRoleIdByList(userRoleList);
        List<RolePermission> rolePermissionList = rolePermissionService.getByRoleIdList(roleIds);
        List<String> permissionIds = getPermissionIdInList(rolePermissionList);
        List<Permission> permissionList = permissionService.getByPermissionIdList(permissionIds);
        return getPermissionUrlInList(permissionList);
    }

    /**
     * 把返回的对象存入缓存
     * @param bean
     */
    public void saveToCache(LoginResultBean bean) {
        String token = bean.getToken();
        List<String> permissionURLs = bean.getPermissions();
        RedisUtils.setKeyOfObject(redisUtilsTemplate, token, permissionURLs);
        RedisUtils.setExpire(redisUtilsTemplate, token, 10);
    }
}
