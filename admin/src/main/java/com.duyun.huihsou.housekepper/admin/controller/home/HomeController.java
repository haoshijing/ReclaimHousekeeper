package com.duyun.huihsou.housekepper.admin.controller.home;

import com.duyun.huihsou.housekepper.admin.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.admin.request.AdminUserParams;
import com.duyun.huihsou.housekepper.admin.service.sysuser.SysUserService;
import com.duyun.huihsou.housekepper.admin.vo.SysUserVO;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.util.RedisTool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private RedisTool redisTool;

    @Autowired
    private SysUserService sysUserService;


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
    public void login(@RequestBody AdminUserParams params, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String verifyCode = params.getVerifyCode();
//        if (!verifyCode.equals(redisTool.get("admin_verifycode"))) {
//            //todo 验证码
////            throw new RuntimeException("无效的验证码！");
//        } else if (params.getName()==null||params.getPassWord()==null) {
//            throw new RuntimeException("用户名密码不能为空！");
//        }
        SysUserVO sysUserVO = sysUserService.checkLogin(params);

        Cookie c = new Cookie("userName",sysUserVO.getName());
        c.setPath(request.getContextPath());
        c.setMaxAge(3600);
        //将此cookie发送给客户端保存
        response.addCookie(c);

        Cookie c2 = new Cookie("mobile",sysUserVO.getMobile());
        c2.setPath(request.getContextPath());
        c2.setMaxAge(3600);
        response.addCookie(c2);

        Cookie c3 = new Cookie("token",sysUserVO.getToken());
        c3.setPath(request.getContextPath());
        c3.setMaxAge(3600);
        response.addCookie(c3);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(true);
        response.getWriter().close();
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndex(HttpServletRequest request, Model model) {
        Cookie[] cookies = request.getCookies();
        List<Cookie> list= Arrays.asList(cookies);
        for (Cookie c:list) {
            if ("userName".equals(c.getName())) {
                model.addAttribute("userName", c.getValue());
            }
            if ("mobile".equals(c.getName())) {
                model.addAttribute("mobile", c.getValue());
            }
        }
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
