package com.duyun.huihsou.housekepper.admin.controller.home;

import com.alibaba.fastjson.JSONObject;
import com.duyun.huihsou.housekepper.admin.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.admin.request.AdminUserParams;
import com.duyun.huihsou.housekepper.admin.service.sysuser.SysUserService;
import com.duyun.huihsou.housekepper.admin.vo.SysUserVO;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.util.RedisTool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomeController {

    @Autowired
    private RedisTool redisTool;

    @Autowired
    private SysUserService sysUserService;

    @VisitorAccessible
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }

    @VisitorAccessible
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "login";
    }

    @VisitorAccessible
    @ResponseBody
    @RequestMapping(value = "/checklogin", method = RequestMethod.POST, produces = {"application/json"})
    public void login(@RequestBody AdminUserParams params, HttpServletResponse response) throws IOException {
        String verifyCode = params.getVerifyCode();
//        if (!verifyCode.equals(redisTool.get("admin_verifycode"))) {
//            //todo 验证码
////            throw new RuntimeException("无效的验证码！");
//        } else if (params.getName()==null||params.getPassWord()==null) {
//            throw new RuntimeException("用户名密码不能为空！");
//        }
        SysUserVO sysUserVO = sysUserService.checkLogin(params);
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("token",sysUserVO.getToken());
        jsonObject.put("name",sysUserVO.getName());
        jsonObject.put("mobile",sysUserVO.getMobile());
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(jsonObject.toJSONString());
        response.getWriter().close();
    }

    @VisitorAccessible
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndex() {
        return "index";
    }

    @VisitorAccessible
    @RequestMapping(value = "/sys/user/register", method = RequestMethod.GET, produces = "text/plain")
    public ApiResponse getRegister(String name, String passWord, String mobile) {
        if (StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(passWord)) {
            sysUserService.register(name, passWord, mobile);
        }
        return new ApiResponse("OK");
    }
}
