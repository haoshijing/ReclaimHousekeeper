package com.duyun.huishou.housekeeper.mapper;

import com.duyun.huishou.housekeeper.po.CategoryEntity;

import java.util.List;

public interface CategoryEntityMapper extends IBaseDao<CategoryEntity>{
    List<CategoryEntity> selectByParentId(Integer parentId);
}