package com.janita.like.util;

import com.janita.like.bean.LoginResultBean;
import com.janita.like.entity.User;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Janita on 2017/6/21 0021-下午 4:24
 * 该类是：
 */
public class BeanConvertUtils {

    public static LoginResultBean convertUserToLoginResultBean(User user, Set<String> permissions) {
        LoginResultBean bean = null;
        if (user != null) {
            bean = new LoginResultBean();
            bean.setUserId(user.getUserId());
            bean.setLoginName(user.getLoginName());
            bean.setUsername(user.getUsername());
            bean.setPermissions(new ArrayList<>(permissions));
        }
        return bean;
    }
}
