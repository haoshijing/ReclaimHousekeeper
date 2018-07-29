package com.duyun.huihsou.housekepper.admin.service.news;


import com.duyun.huihsou.housekepper.admin.service.AbstractBaseService;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
import com.duyun.huishou.housekeeper.mapper.NewsEntityMapper;
import com.duyun.huishou.housekeeper.mapper.NewsTypeEntityMapper;
import com.duyun.huishou.housekeeper.po.NewsEntity;
import com.duyun.huishou.housekeeper.po.NewsTypeEntity;
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
public class NewsTypeServiceImpl extends AbstractBaseService<NewsTypeEntity> implements NewsTypeService {

    @Autowired
    private NewsTypeEntityMapper newsTypeEntityMapper;


    @Override
    public IBaseDao getMapper() {
        return newsTypeEntityMapper;
    }

    @Override
    public List<NewsTypeEntity> getAll() {
        return newsTypeEntityMapper.selectAll();
    }

}
