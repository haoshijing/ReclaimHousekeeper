package com.duyun.huihsou.housekepper.portal.service.user;


import com.duyun.huihsou.housekepper.portal.service.IBaseService;
import com.duyun.huihsou.housekepper.portal.vo.ResData;
import com.duyun.huishou.housekeeper.po.User;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */
public interface UserService extends IBaseService<User> {

    /**
     * 通过openId 获取user
     * @param openId
     * @return
     */
    User queryByOpenId(String openId);

    void processSessionData(ResData jsData);

    /**
     * test
     * @param userId
     * @return
     */
    User queryById(Integer userId);
}
