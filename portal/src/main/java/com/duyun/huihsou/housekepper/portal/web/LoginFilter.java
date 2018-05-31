package com.duyun.huihsou.housekepper.portal.web;

import com.alibaba.fastjson.JSON;
import com.duyun.huihsou.housekepper.portal.inteceptor.VisitorAccessible;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.constants.RetCode;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.duyun.huihsou.housekepper.portal.constants.Constants.TICKET;


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
    RedisTemplate<String, String> redisTemplate;



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        try{
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            VisitorAccessible annotation = handlerMethod.getMethodAnnotation(VisitorAccessible.class);
            if(annotation!=null){
                return true;
            }
            String ticket  = request.getHeader(TICKET);
            if(StringUtils.isEmpty(ticket)){
                ApiResponse tokenValidResponse = new ApiResponse(RetCode.TOKEN_VALID, "ticket error", null);
                response.getWriter().print(JSON.toJSON(tokenValidResponse));
                return false;
            }
            String currentUser = redisTemplate.opsForValue().get(ticket);
            //黑名单用户
            JSONObject jsonObject = JSONObject.fromObject(currentUser);
            Integer uid = jsonObject.getInt("userId");
            try {
                if(StringUtils.isEmpty(currentUser)){
                    ApiResponse tokenValidResponse = new ApiResponse(RetCode.TOKEN_VALID, "ticket expired", null);
                    response.getWriter().print(JSON.toJSON(tokenValidResponse));
                    return false;
                }

            } catch (Exception e) {
                ApiResponse tokenValidResponse = new ApiResponse(RetCode.TOKEN_VALID, "ticket expired", null);
                response.getWriter().print(JSON.toJSON(tokenValidResponse));
                return false;
            }
            request.setAttribute("currentUser", currentUser);
            return true;
        }catch (Exception e){
            log.error("获取凭证失败", e.getMessage());
            return false;
        }
    }


}
