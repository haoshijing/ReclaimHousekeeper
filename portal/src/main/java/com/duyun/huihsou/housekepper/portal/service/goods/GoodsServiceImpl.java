package com.duyun.huihsou.housekepper.portal.service.goods;

import com.duyun.huihsou.housekepper.portal.service.attribute.AttributeService;
import com.duyun.huihsou.housekepper.portal.service.category.CategoryService;
import com.duyun.huihsou.housekepper.portal.vo.ItemSkuVO;
import com.duyun.huishou.housekeeper.po.AttributeDetailEntity;
import com.duyun.huishou.housekeeper.po.CategoryEntity;
import com.duyun.huishou.housekeeper.po.ItemSkuEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private ItemSkuService itemSkuService;

    @Autowired
    private AttributeService attributeService;

    @Autowired
    private CategoryService categoryService;
    @Override
    public Integer save(ItemSkuEntity itemSkuEntity) {
        if (itemSkuEntity.getId() == null){
            getPrice(itemSkuEntity);
            itemSkuEntity.setInsertTime(System.currentTimeMillis());
            itemSkuEntity.setLastUpdateTime(System.currentTimeMillis());
            itemSkuService.insert(itemSkuEntity);
        } else {
            itemSkuEntity.setLastUpdateTime(System.currentTimeMillis());
            itemSkuService.updateByPrimaryKeySelective(itemSkuEntity);
        }
        return itemSkuEntity.getId();
    }

    @Override
    public ItemSkuVO get(ItemSkuEntity itemSkuEntity) {
        ItemSkuVO vo = new ItemSkuVO();
        itemSkuEntity = itemSkuService.selectByPrimaryKey(itemSkuEntity.getId());
        BeanUtils.copyProperties(itemSkuEntity, vo);
        return vo;
    }

    private void getPrice(ItemSkuEntity itemSkuEntity) {
        Integer categoryId = itemSkuEntity.getCategoryId();
        CategoryEntity entity = categoryService.selectByPrimaryKey(categoryId);
        if (entity != null){
            String[] attributeDetailArr = itemSkuEntity.getAttributeDetailids().split(",");
            if (attributeDetailArr.length <= 0) {
                return;
            }
            final BigDecimal[] price = {entity.getPrice()};
            Arrays.asList(attributeDetailArr).forEach(obj->{
                Map<String,Object> map = new HashMap<>();
                map.put("id", Integer.valueOf(obj));
                List<AttributeDetailEntity> entityList = attributeService.getAttributeDetailByCondetion(map);
            price[0] = price[0].subtract(price[0].multiply(entityList.get(0).getPercentage()));
            });
            itemSkuEntity.setPrice(price[0].setScale(2,BigDecimal.ROUND_DOWN));
        } else {
            throw new RuntimeException("产品不存在！");
        }

    }
}
