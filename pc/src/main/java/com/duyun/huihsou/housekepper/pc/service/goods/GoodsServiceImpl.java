package com.duyun.huihsou.housekepper.pc.service.goods;

import com.duyun.huishou.housekeeper.po.ItemSkuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private ItemSkuService itemSkuService;

    @Override
    public Integer save(ItemSkuEntity itemSkuEntity) {
        if (itemSkuEntity.getId() == null){
            itemSkuEntity.setInsertTime(System.currentTimeMillis());
            itemSkuEntity.setLastUpdateTime(System.currentTimeMillis());
            itemSkuService.insert(itemSkuEntity);
        } else {

            itemSkuEntity.setLastUpdateTime(System.currentTimeMillis());
            itemSkuService.updateByPrimaryKeySelective(itemSkuEntity);
        }

        return itemSkuEntity.getId();
    }
}
