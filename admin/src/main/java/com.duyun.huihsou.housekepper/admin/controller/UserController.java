package com.duyun.huihsou.housekepper.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author haoshijing
 * @version 2018年05月08日 21:13
 **/
@Controller
@RequestMapping("/admin/sys/user")
public class UserController {

//    @Autowired
//    private UserService userService;
//
//    @VisitorAccessible
//    @RequestMapping(value = "/login",  method = RequestMethod.POST, produces="application/json")
//    public ApiResponse<String> login(@RequestBody UserParams params) {
//        if (params.getMobile()==null||params.getPassword()==null) {
//            return  new ApiResponse(RetCode.ERROR_PARAMS, "必填参数不能为空！");
//        } else if (!MobileUtil.isMobile(params.getMobile())) {
//            return  new ApiResponse(RetCode.ERROR_PARAMS, "请输入正确手机号！");
//        }
//        String token = userService.login(params);
//        return new ApiResponse<>(token);
//    }
//
//    @VisitorAccessible
//    @RequestMapping(value = "/register", method = RequestMethod.POST, produces="application/json")
//    public ApiResponse<Boolean> register(@RequestBody UserParams params) {
//        if (params.getMobile()==null||params.getNewPwd1()==null||params.getNewPwd2()==null
//                ||params.getVerifyCode()==null) {
//            return  new ApiResponse(RetCode.ERROR_PARAMS, "必填参数不能为空！");
//        } else if (!MobileUtil.isMobile(params.getMobile())) {
//            return  new ApiResponse(RetCode.ERROR_PARAMS, "请输入正确手机号！");
//        }
//        userService.register(params);
//        return new ApiResponse<>();
//    }
//
//    /**
//     * 重置密码
//     * @param params
//     * @return
//     */
//    @RequestMapping(value = "/repwd", method = RequestMethod.POST, produces="application/json")
//    public ApiResponse<Boolean> repwd(@RequestBody UserParams params) {
//        if (params.getMobile()==null||params.getNewPwd1()==null||params.getNewPwd2()==null
//                ||params.getVerifyCode()==null) {
//            return  new ApiResponse(RetCode.ERROR_PARAMS, "必填参数不能为空！");
//        } else if (!MobileUtil.isMobile(params.getMobile())) {
//            return  new ApiResponse(RetCode.ERROR_PARAMS, "请输入正确手机号！");
//        }
//        UserEntity userEntity = GlobalHolder.getCurrentLoginUser();
//        Boolean result = userService.repwd(params, userEntity);
//        return new ApiResponse<>(result);
//    }
}
