package com.duyun.huihsou.housekepper.pc.service;

import com.duyun.huihsou.housekepper.pc.security.model.User;

/**
 * Created by zhongmc on 2018/6/27.
 */
public interface UserService {
    User findByUsername(String username);
}
