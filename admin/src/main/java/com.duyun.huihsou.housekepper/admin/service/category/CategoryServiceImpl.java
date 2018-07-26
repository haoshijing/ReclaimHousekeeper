package com.duyun.huihsou.housekepper.admin.service.category;


import com.duyun.huihsou.housekepper.admin.request.BaseParams;
import com.duyun.huihsou.housekepper.admin.service.AbstractBaseService;
import com.duyun.huihsou.housekepper.admin.vo.CategoryVO;
import com.duyun.huishou.housekeeper.mapper.CategoryEntityMapper;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
import com.duyun.huishou.housekeeper.po.CategoryEntity;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<CategoryEntity> getList() {

        List<CategoryEntity> list =  categoryEntityMapper.findByParams();

        return list;
    }

    @Override
    public Integer getNum() {
        return categoryEntityMapper.getCount();
    }

    @Override
    public List<CategoryEntity> selectByType() {
        return categoryEntityMapper.selectByType();
    }

    @Override
    public IBaseDao getMapper() {
        return categoryEntityMapper;
    }
}
