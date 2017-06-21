package com.janita.like.service.base;

import com.janita.like.dao.RoleDAO;
import com.janita.like.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Janita on 2017/6/21 0021-下午 12:45
 * 该类是：
 */
@Service
public class RoleService {

    private final RoleDAO roleDAO;

    @Autowired(required = false)
    public RoleService(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    /**
     * 根据 roleId 列表 查询 对应的 role 列表
     * @param roleIds
     * @return
     */
    public List<Role> getRoleListByRoleIdList(List<String> roleIds) {
        if (!roleIds.isEmpty()) {
            return roleDAO.getRoleListByRoleIdList(roleIds);
        }
        return null;
    }
}
