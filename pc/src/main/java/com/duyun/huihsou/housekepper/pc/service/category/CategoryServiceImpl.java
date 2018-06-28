package com.duyun.huihsou.housekepper.pc.service.category;


import com.duyun.huihsou.housekepper.pc.service.AbstractBaseService;
import com.duyun.huishou.housekeeper.mapper.CategoryEntityMapper;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
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

    @Override
    public IBaseDao getMapper() {
        return categoryEntityMapper;
    }
}
