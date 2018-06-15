package com.duyun.huihsou.housekepper.portal.service.category;


import com.duyun.huihsou.housekepper.portal.service.AbstractBaseService;
import com.duyun.huishou.housekeeper.mapper.CategoryEntityMapper;
import com.duyun.huishou.housekeeper.po.CategoryEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */

@Service
@Slf4j
public class CategoryServiceImpl extends AbstractBaseService<CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryEntityMapper categoryEntityMapper;


    @Override
    public List<CategoryEntity> getCategoryByParentId(Integer parentId) {
        return categoryEntityMapper.selectByParentId(parentId);
    }
}
