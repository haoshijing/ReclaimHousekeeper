package com.duyun.huishou.housekeeper.mapper;

import com.duyun.huishou.housekeeper.po.BannerChannelEntity;

import java.util.List;

public interface BannerChannelEntityMapper extends IBaseDao<BannerChannelEntity>{

    List<BannerChannelEntity> getList();
}