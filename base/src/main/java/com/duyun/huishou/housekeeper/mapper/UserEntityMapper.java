package com.duyun.huishou.housekeeper.mapper;

import com.duyun.huishou.housekeeper.po.UserEntity;

public interface UserEntityMapper extends IBaseDao<UserEntity>{


    UserEntity selectByOpenId(String openId);

    UserEntity selectByMobile(String mobile);

}