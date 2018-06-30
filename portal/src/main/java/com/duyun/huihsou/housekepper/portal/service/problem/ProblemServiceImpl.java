package com.duyun.huihsou.housekepper.portal.service.problem;


import com.duyun.huihsou.housekepper.portal.request.BaseParams;
import com.duyun.huihsou.housekepper.portal.service.AbstractBaseService;
import com.duyun.huihsou.housekepper.portal.service.news.NewsService;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
import com.duyun.huishou.housekeeper.mapper.NewsEntityMapper;
import com.duyun.huishou.housekeeper.mapper.ProblemEntityMapper;
import com.duyun.huishou.housekeeper.po.NewsEntity;
import com.duyun.huishou.housekeeper.po.ProblemEntity;
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
public class ProblemServiceImpl extends AbstractBaseService<ProblemEntity> implements ProblemService {

    @Autowired
    private ProblemEntityMapper problemEntityMapper;


    @Override
    public IBaseDao getMapper() {
        return problemEntityMapper;
    }

    @Override
    public List<ProblemEntity> getAll(BaseParams params) {
        Map<String, Object> map = new HashMap<>();
        map.put("pageNo",params.getPageNo() - 1);
        map.put("pageSize",params.getPageSize() * params.getPageNo());
        return problemEntityMapper.selectAll(map);
    }
}
