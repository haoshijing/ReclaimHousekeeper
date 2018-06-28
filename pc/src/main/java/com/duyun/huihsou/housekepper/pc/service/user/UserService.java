package com.duyun.huihsou.housekepper.pc.service.user;



import com.duyun.huihsou.housekepper.pc.request.UserParams;
import com.duyun.huihsou.housekepper.pc.service.IBaseService;
import com.duyun.huihsou.housekepper.pc.vo.ResData;
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

    String register(UserParams params);

    Boolean repwd(UserParams params, UserEntity userEntity);

    UserEntity selectByOpenId(String openId);
}
