package com.duyun.huihsou.housekepper.pc.controller;

import com.alibaba.fastjson.JSON;
import com.duyun.huihsou.housekepper.pc.gloabal.GlobalHolder;
import com.duyun.huihsou.housekepper.pc.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.pc.request.UserParams;
import com.duyun.huihsou.housekepper.pc.service.user.UserService;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.constants.RetCode;
import com.duyun.huishou.housekeeper.po.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pc/portal/user")
public class UserController {


    @Autowired
    private UserService userService;

    @VisitorAccessible
    @RequestMapping(value = "/login",  method = RequestMethod.GET, produces="application/json")
    public Object login(@RequestBody UserParams params) {
        try{
            return JSON.toJSON(new ApiResponse<>(userService.login(params)));
        } catch (Exception e){
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "token失败"));
        }

    }

    @VisitorAccessible
    @RequestMapping(value = "/register", method = RequestMethod.GET, produces="application/json")
    public Object register(@RequestBody UserParams params) {
        try {
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, userService.register(params)));
        } catch (Exception e) {
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "token失败"));
        }
    }

    /**
     * 重置密码
     * @param params
     * @return
     */
    @RequestMapping(value = "/repwd", method = RequestMethod.POST, produces="application/json")
    public Object repwd(@RequestBody UserParams params) {
        try {
            return JSON.toJSON(new ApiResponse<>(userService.repwd(params, GlobalHolder.getCurrentLoginUser())));
        }catch (Exception e) {
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "token失败"));
        }
    }


}
