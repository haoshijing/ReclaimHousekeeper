package com.duyun.huihsou.housekepper.admin.service.banner;


import com.duyun.huihsou.housekepper.admin.service.AbstractBaseService;
import com.duyun.huishou.housekeeper.mapper.BannerConfigEntityMapper;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
import com.duyun.huishou.housekeeper.po.BannerConfigEntity;
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
public class BannerConfigServiceImpl extends AbstractBaseService<BannerConfigEntity> implements BannerConfigService {

    @Autowired
    private BannerConfigEntityMapper bannerConfigEntityMapper;


    @Override
    public IBaseDao getMapper() {
        return bannerConfigEntityMapper;
    }

    @Override
    public List<BannerConfigEntity> getList() {
        return bannerConfigEntityMapper.getList();
    }
}
