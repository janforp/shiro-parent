package com.janita.project.service.base;

import com.janita.project.dao.HospitalUserDAO;
import com.janita.project.entity.HospitalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Janita on 2017/6/21 0021-上午 11:57
 * 该类是：
 */
@Service
public class UserService {

    private final HospitalUserDAO userDAO;

    @Autowired(required = false)
    public UserService(HospitalUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public HospitalUser getByLoginName(String loginName) {
        return userDAO.getByLoginName(loginName);
    }
}
