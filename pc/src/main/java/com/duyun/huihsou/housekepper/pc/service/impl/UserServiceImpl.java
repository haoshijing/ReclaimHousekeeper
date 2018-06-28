package com.duyun.huihsou.housekepper.pc.service.impl;

import com.duyun.huihsou.housekepper.pc.security.model.User;
import com.duyun.huihsou.housekepper.pc.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by zhongmc on 2018/6/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User findByUsername(String username) {
        User u = new User();
        u.setUsername("admin");
        u.setPassword("admin");
        u.setAuthorities(new ArrayList<>());
        u.setEnabled(true);
        return u;
    }
}
