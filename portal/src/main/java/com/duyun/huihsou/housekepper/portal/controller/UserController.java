package com.duyun.huihsou.housekepper.portal.controller;

import com.duyun.huihsou.housekepper.portal.gloabal.GlobalHolder;
import com.duyun.huihsou.housekepper.portal.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.portal.request.UserParams;
import com.duyun.huihsou.housekepper.portal.service.user.UserService;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.po.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haoshijing
 * @version 2018年05月08日 21:13
 **/
@RestController
@RequestMapping("/h5/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @VisitorAccessible
    @RequestMapping(value = "/login",  method = RequestMethod.POST, produces="application/json")
    public ApiResponse<String> login(@RequestBody UserParams params) {
        String token = userService.login(params);
        return new ApiResponse<>(token);
    }

    @VisitorAccessible
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces="application/json")
    public ApiResponse<Boolean> register(@RequestBody UserParams params) {
        userService.register(params);
        return new ApiResponse<>();
    }

    /**
     * 重置密码
     * @param params
     * @return
     */
    @RequestMapping(value = "/repwd", method = RequestMethod.POST, produces="application/json")
    public ApiResponse<Boolean> repwd(@RequestBody UserParams params) {
        UserEntity userEntity = GlobalHolder.getCurrentLoginUser();
        Boolean result = userService.repwd(params, userEntity);
        return new ApiResponse<>(result);
    }
}
