package com.duyun.huihsou.housekepper.admin.service.user;


import com.duyun.huihsou.housekepper.admin.service.IBaseService;
import com.duyun.huishou.housekeeper.po.UserEntity;

import java.util.List;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */
public interface UserService extends IBaseService<UserEntity> {

    List<UserEntity> getList();
}
