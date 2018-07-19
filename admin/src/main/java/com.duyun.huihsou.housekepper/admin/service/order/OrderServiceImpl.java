package com.duyun.huihsou.housekepper.admin.service.order;

import com.duyun.huihsou.housekepper.admin.service.AbstractBaseService;
import com.duyun.huihsou.housekepper.admin.service.attribute.AttributeService;
import com.duyun.huihsou.housekepper.admin.vo.OrderVO;
import com.duyun.huishou.housekeeper.dto.OrderDTO;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
import com.duyun.huishou.housekeeper.mapper.OrderEntityMapper;
import com.duyun.huishou.housekeeper.po.AttributeDetailEntity;
import com.duyun.huishou.housekeeper.po.OrderEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl extends AbstractBaseService<OrderEntity> implements OrderService  {

    @Autowired
    private OrderEntityMapper orderEntityMapper;

    @Autowired
    AttributeService attributeService;

    @Override
    public IBaseDao getMapper() {
        return orderEntityMapper;
    }

    @Override
    public List<OrderVO> getOrderInfo(Integer userId, Integer orderStatus) {
        List<OrderVO> list = new ArrayList<>();
        List<OrderDTO> orderDTOList = orderEntityMapper.getOrderInfo(userId, orderStatus);
        orderDTOList.forEach(obj->{
            OrderVO vo = new OrderVO();
            String attributeDetailIds = obj.getAttributeDetails();
            BeanUtils.copyProperties(obj, vo);
            getAttributeDetailList(vo, attributeDetailIds);
            list.add(vo);
        });

        return list;
    }

    @Override
    public List<OrderEntity> getList() {
        return orderEntityMapper.getList();
    }

    private void getAttributeDetailList(OrderVO vo, String attributeDetailIds) {
        String[] attributeDetailArr = attributeDetailIds.split(",");
        if (attributeDetailArr.length <= 0) {
            return;
        }
        List<String> list = new ArrayList<>();
        Arrays.asList(attributeDetailArr).forEach(obj->{
            Map<String,Object> map = new HashMap<>();
            map.put("id", Integer.valueOf(obj));
            List<AttributeDetailEntity> entityList = attributeService.getAttributeDetailByCondetion(map);
            list.add(entityList.get(0).getValue());
        });
        vo.setAttributeDetailList(list);
    }
}
