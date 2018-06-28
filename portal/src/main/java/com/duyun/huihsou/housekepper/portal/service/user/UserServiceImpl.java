package com.duyun.huihsou.housekepper.portal.service.user;


import com.duyun.huihsou.housekepper.portal.service.AbstractBaseService;
import com.duyun.huishou.housekeeper.mapper.UserEntityMapper;
import com.duyun.huishou.housekeeper.po.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */

@Service
@Slf4j
public class UserServiceImpl extends AbstractBaseService<UserEntity> implements UserService {

    @Autowired
    private UserEntityMapper userMapper;

}
