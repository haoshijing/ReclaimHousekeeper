package com.duyun.huihsou.housekepper.admin.service.attribute;


import com.duyun.huihsou.housekepper.admin.service.AbstractBaseService;
import com.duyun.huishou.housekeeper.mapper.AttributeDetailEntityMapper;
import com.duyun.huishou.housekeeper.mapper.AttributeEntityMapper;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
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
public class AttributeDetailServiceImpl extends AbstractBaseService<AttributeDetailEntity> implements AttributeDetailService {


    @Autowired
    private AttributeDetailEntityMapper attributeDetailEntityMapper;



    @Override
    public IBaseDao getMapper() {
        return attributeDetailEntityMapper;
    }
}
