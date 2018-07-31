package com.duyun.huihsou.housekepper.portal.service.goods;

import com.duyun.huihsou.housekepper.portal.vo.ItemSkuVO;
import com.duyun.huishou.housekeeper.po.ItemSkuEntity;

public interface GoodsService {
    Integer save(ItemSkuEntity map);

    ItemSkuVO get(ItemSkuEntity itemSkuEntity);
}
