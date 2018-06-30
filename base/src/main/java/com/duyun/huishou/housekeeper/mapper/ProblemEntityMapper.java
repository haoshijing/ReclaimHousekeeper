package com.duyun.huishou.housekeeper.mapper;

import com.duyun.huishou.housekeeper.po.ProblemEntity;

import java.util.List;
import java.util.Map;

public interface ProblemEntityMapper extends IBaseDao<ProblemEntity>{

    List<ProblemEntity> selectAll(Map<String,Object> map);
}