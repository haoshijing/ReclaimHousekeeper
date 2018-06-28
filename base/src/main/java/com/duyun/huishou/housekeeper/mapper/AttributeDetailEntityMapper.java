package com.duyun.huishou.housekeeper.mapper;

import com.duyun.huishou.housekeeper.po.AttributeDetailEntity;

import java.util.List;
import java.util.Map;

public interface AttributeDetailEntityMapper extends IBaseDao<AttributeDetailEntity>{

    List<AttributeDetailEntity> selectByCondition(Map<String,Object> map);
}