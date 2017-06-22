package com.janita.project.service.base;

import com.janita.project.dao.PermissionDAO;
import com.janita.project.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Janita on 2017/6/21 0021-下午 1:03
 * 该类是：
 */
@Service
public class PermissionService {

    private final PermissionDAO permissionDAO;

    @Autowired(required = false)
    public PermissionService(PermissionDAO permissionDAO) {
        this.permissionDAO = permissionDAO;
    }

    public List<Permission> getByPermissionIdList(List<String> permissionIds) {
        List<Permission> permissionList = null;
        if (!permissionIds.isEmpty()) {
            permissionList = permissionDAO.getByPermissionIdList(permissionIds);
        }
        return permissionList;
    }
}
