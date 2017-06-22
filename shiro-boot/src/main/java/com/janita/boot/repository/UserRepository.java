package com.janita.boot.repository;

import com.janita.boot.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Janita on 2017/6/22 0022-下午 2:06
 * 该类是：
 */
@Repository
public class UserRepository {

    public User findByEmailAndActive(String email, boolean b) {
        Map<String, User> userMap = User.userMap();
        return userMap.get(email);
    }

    public List<User> findAll() {
        Collection<User> users =  User.userMap().values();
        return new ArrayList<>(users);
    }

    public void deleteAll() {
    }

    public void save(User user) {
    }
}
