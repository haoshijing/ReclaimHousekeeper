package com.duyun.huihsou.housekepper.admin.service.category;


import com.duyun.huihsou.housekepper.admin.request.BaseParams;
import com.duyun.huihsou.housekepper.admin.service.IBaseService;
import com.duyun.huihsou.housekepper.admin.vo.CategoryVO;
import com.duyun.huishou.housekeeper.po.CategoryEntity;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */
public interface CategoryService extends IBaseService<CategoryEntity> {

    List<CategoryEntity> getCategoryByParentId(Integer parentId);

    List<CategoryEntity> getList();

    Integer getNum();

    List<CategoryEntity> selectByType();
}
