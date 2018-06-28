package com.duyun.huihsou.housekepper.pc.service.goods;


import com.duyun.huihsou.housekepper.pc.service.AbstractBaseService;
import com.duyun.huishou.housekeeper.aop.NameSpace;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
import com.duyun.huishou.housekeeper.mapper.ItemSkuEntityMapper;
import com.duyun.huishou.housekeeper.po.ItemSkuEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */

@Service
@Slf4j
@NameSpace("com.duyun.huihsou.housekepper.portal.service.goods.ItemSkuServiceImpl")
public class ItemSkuServiceImpl extends AbstractBaseService<ItemSkuEntity> implements ItemSkuService {

    @Autowired
    private ItemSkuEntityMapper itemSkuEntityMapper;

    @Override
    public IBaseDao getMapper() {
        return itemSkuEntityMapper;
    }
}
