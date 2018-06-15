/*
package com.duyun.huihsou.housekepper.portal.service.auth;


import com.alibaba.fastjson.JSONObject;
import com.duyun.huihsou.housekepper.portal.service.user.UserService;
import com.duyun.huihsou.housekepper.portal.vo.ResData;
import com.duyun.huishou.housekeeper.po.User;
import com.duyun.huishou.housekeeper.util.HttpTool;
import com.duyun.huishou.housekeeper.util.RedisTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.TimeUnit;

*/
/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 *//*


@Service
@Slf4j
public class AuthService {
    public static final String SESSION_KEY_API_PREFIX = "https://api.weixin.qq.com/sns/jscode2session?";
    @Value("${wxAppId}")
    private String wxAppId;

    @Value("${wxAppSec}")
    private String wxAppSec;

    @Autowired
    private RedisTool redisTool;

    @Autowired
    private UserService userService;

    @Autowired
    RedisTemplate<String, String> redisTemplate;


    */
/**
     * 返回客户端凭证
     * @param code
     * @return
     *//*

    public String getTicket(String code){
        ResData data = getSessionKey(code);
        if(data != null){
            userService.processSessionData(data);
            User user = userService.queryByOpenId(data.getOpenId());
            if (user != null){
                net.sf.json.JSONObject json = new net.sf.json.JSONObject();
                json.put("openId", data.getOpenId());
                json.put("userId", user.getId());
                if (data.getTicket() != null){
                    List<String> keys = redisTool.like("*" + user.getOpenId());
                    if (keys.size() != 0){
                        redisTool.remove(keys);
                    }
                    redisTool.set(data.getTicket(), json.toString(),
                            60 * 60 * 24 * 20, TimeUnit.SECONDS);
                }
                String ticket = data.getTicket();
                return ticket;
            }
        }
        return null;

    }

    */
/**
     * 设置session_key 到redis 并返回修改后的session给客户端
     * @param code
     * @return
     *//*

    public ResData getSessionKey(String code){
        //构建session url
        StringBuilder builder = new StringBuilder(SESSION_KEY_API_PREFIX);
        builder.append("appid=" + wxAppId)
                .append("&secret=" + wxAppSec)
                .append("&js_code=" + code)
                .append("&grant_type=authorization_code");
        //http请求
        String sessionInfo = HttpTool.post(builder.toString());
        JSONObject jsonSession = JSONObject.parseObject(sessionInfo);
        log.info("the weixin sns info is " + sessionInfo);
        String sessionKey = jsonSession.getString("session_key");
        String openId = jsonSession.getString("openid");
        String unionId = jsonSession.getString("unionId");
        //session_key + "#" + openId
        StringBuilder ticket = new StringBuilder();
        ticket.append(sessionKey).append("#").append(openId);
        if (openId == null){
            return new ResData(null, unionId, sessionKey, null,"code获取openId失败");
        }
//        String ticket = getEncode("MD5", openId);
        return new ResData(openId, unionId, sessionKey, ticket.toString(), "getSessionKey成功");
    }

    */
/**
     * 获取一个随机加密值
     * @param codeType
     * @param content
     * @return
     *//*

    private String getEncode(String codeType, String content) {
        try {
            // 获取一个实例，并传入加密方式
            MessageDigest digest = MessageDigest.getInstance(codeType);
            digest.reset();
            // 写入内容
            digest.update(content.getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte b : digest.digest()) {
                builder.append(Integer.toHexString((b >> 4) & 0xf));
                builder.append(Integer.toHexString(b & 0xf));
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
*/
