package com.duyun.huihsou.housekepper.portal.service.banner;


import com.duyun.huihsou.housekepper.portal.service.IBaseService;
import com.duyun.huishou.housekeeper.po.BannerConfigEntity;

import java.util.List;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */
public interface BannerConfigService extends IBaseService<BannerConfigEntity> {

    List<BannerConfigEntity> getBannerConfigByConfition(BannerConfigEntity entity);
}
