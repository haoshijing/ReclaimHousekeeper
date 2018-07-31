package com.duyun.huihsou.housekepper.portal.service.news;


import com.duyun.huihsou.housekepper.portal.request.BaseParams;
import com.duyun.huihsou.housekepper.portal.request.NewsParams;
import com.duyun.huihsou.housekepper.portal.service.AbstractBaseService;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
import com.duyun.huishou.housekeeper.mapper.NewsEntityMapper;
import com.duyun.huishou.housekeeper.po.NewsEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class NewsServiceImpl extends AbstractBaseService<NewsEntity> implements NewsService {

    @Autowired
    private NewsEntityMapper newsEntityMapper;


    @Override
    public IBaseDao getMapper() {
        return newsEntityMapper;
    }

    @Override
    public List<NewsEntity> getAll(NewsParams params) {
        Map<String, Object> map = new HashMap<>();
        map.put("pageNo",params.getPageNo() - 1);
        map.put("pageSize",params.getPageSize() * params.getPageNo());
        map.put("type",params.getType());
        return newsEntityMapper.selectAll(map);
    }

    @Override
    public Integer getNum() {
        return newsEntityMapper.selectAllCount();
    }
}
