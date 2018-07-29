package com.duyun.huihsou.housekepper.admin.service.banner;


import com.duyun.huihsou.housekepper.admin.service.IBaseService;
import com.duyun.huishou.housekeeper.po.BannerChannelEntity;

import java.util.List;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */
public interface BannerChannelService extends IBaseService<BannerChannelEntity> {


    List<BannerChannelEntity> getList();
}
