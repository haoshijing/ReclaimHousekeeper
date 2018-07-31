package com.duyun.huihsou.housekepper.portal.service.news;


import com.duyun.huihsou.housekepper.portal.request.BaseParams;
import com.duyun.huihsou.housekepper.portal.request.NewsParams;
import com.duyun.huihsou.housekepper.portal.service.IBaseService;
import com.duyun.huishou.housekeeper.po.NewsEntity;

import java.util.List;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */
public interface NewsService extends IBaseService<NewsEntity> {

    List<NewsEntity> getAll(NewsParams params);

    Integer getNum();
}
