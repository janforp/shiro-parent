package com.janita.project.service.base;

import com.janita.project.dao.UserDAO;
import com.janita.project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Janita on 2017/6/21 0021-上午 11:57
 * 该类是：
 */
@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired(required = false)
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User getByLoginName(String loginName) {
        return userDAO.getByLoginName(loginName);
    }
}
