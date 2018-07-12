package com.duyun.huihsou.housekepper.portal.service.user;


import com.duyun.huihsou.housekepper.portal.request.UserParams;
import com.duyun.huihsou.housekepper.portal.service.IBaseService;
import com.duyun.huihsou.housekepper.portal.vo.ResData;
import com.duyun.huishou.housekeeper.po.UserEntity;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */
public interface UserService extends IBaseService<UserEntity> {

    void processSessionData(ResData data);

    UserEntity queryByOpenId(String openId);

    String login(UserParams params);

    void register(UserParams params);

    Boolean repwd(UserParams params, UserEntity userEntity);

    Boolean getVerifyCode();
}
