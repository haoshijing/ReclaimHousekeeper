package com.duyun.huishou.housekeeper.mapper;

import com.duyun.huishou.housekeeper.po.WordBookEntity;

import java.util.List;

public interface WordBookEntityMapper extends IBaseDao<WordBookEntity>{

    List<WordBookEntity> getList();
}