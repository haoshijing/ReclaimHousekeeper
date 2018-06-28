package com.duyun.huishou.housekeeper.mapper;

import com.duyun.huishou.housekeeper.po.BannerConfigEntity;

import java.util.List;

public interface BannerConfigEntityMapper extends IBaseDao<BannerConfigEntity>{

    List<BannerConfigEntity> selectByCondition(BannerConfigEntity entity);
}