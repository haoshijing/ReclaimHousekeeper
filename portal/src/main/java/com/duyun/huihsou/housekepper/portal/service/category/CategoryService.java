package com.duyun.huihsou.housekepper.portal.service.category;


import com.duyun.huihsou.housekepper.portal.service.IBaseService;
import com.duyun.huishou.housekeeper.po.CategoryEntity;

import java.util.List;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */
public interface CategoryService extends IBaseService<CategoryEntity> {

    List<CategoryEntity> getCategoryByParentId(Integer parentId);
}
