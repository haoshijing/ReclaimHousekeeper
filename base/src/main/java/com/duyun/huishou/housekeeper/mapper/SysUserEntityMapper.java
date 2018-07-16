package com.duyun.huishou.housekeeper.mapper;


import com.duyun.huishou.housekeeper.po.SysUserEntity;

public interface SysUserEntityMapper extends IBaseDao<SysUserEntity>{
    SysUserEntity selectByName(String name);
}