package com.duyun.huihsou.housekepper.portal.service.attribute;


import com.duyun.huihsou.housekepper.portal.service.AbstractBaseService;
import com.duyun.huishou.housekeeper.mapper.AttributeDetailEntityMapper;
import com.duyun.huishou.housekeeper.mapper.AttributeEntityMapper;
import com.duyun.huishou.housekeeper.po.AttributeDetailEntity;
import com.duyun.huishou.housekeeper.po.AttributeEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class AttributeServiceImpl extends AbstractBaseService<AttributeEntity> implements AttributeService {

    @Autowired
    private AttributeEntityMapper attributeEntityMapper;

    @Autowired
    private AttributeDetailEntityMapper attributeDetailEntityMapper;

    @Override
    public List<AttributeEntity> getAttributeByCategoryId(Integer categoryId) {
        return attributeEntityMapper.selectByCategoryId(categoryId);
    }

    @Override
    public List<AttributeDetailEntity> getAttributeDetailByCondetion(Map<String, Object> map) {
        return attributeDetailEntityMapper.selectByCondition(map);
    }
}
