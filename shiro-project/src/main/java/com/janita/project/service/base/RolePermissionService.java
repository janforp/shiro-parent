package com.janita.project.service.base;

import com.janita.project.dao.RolePermissionDAO;
import com.janita.project.entity.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Janita on 2017/6/21 0021-下午 1:04
 * 该类是：
 */
@Service
public class RolePermissionService {

    private final RolePermissionDAO rolePermissionDAO;

    @Autowired(required = false)
    public RolePermissionService(RolePermissionDAO rolePermissionDAO) {
        this.rolePermissionDAO = rolePermissionDAO;
    }

    public List<RolePermission> getByRoleIdList(List<String> roleIds) {
        if (!roleIds.isEmpty()) {
            return rolePermissionDAO.getByRoleIdList(roleIds);
        }
        return null;
    }
}
