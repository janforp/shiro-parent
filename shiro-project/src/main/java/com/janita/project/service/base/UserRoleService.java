package com.janita.project.service.base;

import com.janita.project.dao.UserRoleDAO;
import com.janita.project.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Janita on 2017/6/21 0021-下午 12:47
 * 该类是：
 */
@Service
public class UserRoleService {

    private final UserRoleDAO userRoleDAO;

    @Autowired(required = false)
    public UserRoleService(UserRoleDAO userRoleDAO) {
        this.userRoleDAO = userRoleDAO;
    }

    /**
     * 根据 userid 查询出该用户的所有角色
     * @param userId
     * @return
     */
    public List<UserRole> getByUserId(String userId) {
        return userRoleDAO.getByUserId(userId);
    }
}
