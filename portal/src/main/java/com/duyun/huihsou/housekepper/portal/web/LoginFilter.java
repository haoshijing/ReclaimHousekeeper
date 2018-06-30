package com.duyun.huihsou.housekepper.portal.web;

import com.duyun.huihsou.housekepper.portal.gloabal.GlobalHolder;
import com.duyun.huihsou.housekepper.portal.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.portal.service.user.UserService;
import com.duyun.huishou.housekeeper.po.UserEntity;
import com.duyun.huishou.housekeeper.util.JWTVerifierUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.duyun.huihsou.housekepper.portal.constants.Constants.TOKEN;


/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.web
 * @email cn.lu.duke@gmail.com
 * @date January 14, 2018
 */
@Slf4j
@Component
public class LoginFilter extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;
    @Autowired
    RedisTemplate<String, String> redisTemplate;



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        try{
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            VisitorAccessible annotation = handlerMethod.getMethodAnnotation(VisitorAccessible.class);
            if(annotation!=null){
                return true;
            }
//            String ticket  = request.getHeader(TICKET);
//            if(StringUtils.isEmpty(ticket)){
//                ApiResponse tokenValidResponse = new ApiResponse(RetCode.TOKEN_VALID, "ticket error", null);
//                response.getWriter().print(JSON.toJSON(tokenValidResponse));
//                return false;
//            }
            String token  = request.getHeader(TOKEN);
            if (StringUtils.isNotEmpty(token)) {
                Integer userId = getUserIdFromToken(token);
                if (userId == null) {
                    return false;
                }
                UserEntity entity = userService.selectByPrimaryKey(userId);
                if (entity == null) {
                    return false;
                }
                GlobalHolder.setCurrentLoginUser(entity);
            } else {
                return false;
            }
            return true;
        }catch (Exception e){
            log.error("获取凭证失败", e.getMessage());
            return false;
        }
    }
    private Integer getUserIdFromToken(String token) {
        List tokenList = JWTVerifierUtil.verify(token);
        Integer userId = Integer.valueOf(tokenList.get(2) + "");
        return userId;
    }


}
