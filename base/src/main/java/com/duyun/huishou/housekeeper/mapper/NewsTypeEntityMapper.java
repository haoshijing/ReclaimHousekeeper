package com.duyun.huishou.housekeeper.mapper;

import com.duyun.huishou.housekeeper.po.NewsTypeEntity;

import java.util.List;

public interface NewsTypeEntityMapper extends IBaseDao<NewsTypeEntity>{

    List<NewsTypeEntity> selectAll();
}