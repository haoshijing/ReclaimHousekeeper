package com.duyun.huishou.housekeeper.mapper;

import com.duyun.huishou.housekeeper.po.AttributeEntity;

import java.util.List;

public interface AttributeEntityMapper extends IBaseDao<AttributeEntity>{

    List<AttributeEntity> selectByCategoryId(Integer categoryId);

}