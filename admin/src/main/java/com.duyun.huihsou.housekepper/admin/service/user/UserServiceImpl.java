package com.duyun.huihsou.housekepper.admin.service.user;


import com.duyun.huihsou.housekepper.admin.request.AdminUserParams;
import com.duyun.huihsou.housekepper.admin.service.AbstractBaseService;
import com.duyun.huihsou.housekepper.admin.vo.ResData;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
import com.duyun.huishou.housekeeper.mapper.UserEntityMapper;
import com.duyun.huishou.housekeeper.po.UserEntity;
import com.duyun.huishou.housekeeper.util.EncryptionUtils;
import com.duyun.huishou.housekeeper.util.JWTSignerUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public IBaseDao getMapper() {
        return (IBaseDao)userMapper;
    }

    @Override
    public List<UserEntity> getList() {
        return userMapper.getList();
    }
}
