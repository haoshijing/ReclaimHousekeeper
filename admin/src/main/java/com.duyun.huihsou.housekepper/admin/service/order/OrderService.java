package com.duyun.huihsou.housekepper.admin.service.order;

import com.duyun.huihsou.housekepper.admin.service.IBaseService;
import com.duyun.huihsou.housekepper.admin.vo.OrderVO;
import com.duyun.huishou.housekeeper.po.OrderEntity;

import java.util.List;

public interface OrderService extends IBaseService<OrderEntity> {
    List<OrderVO> getOrderInfo(Integer id, Integer orderStatus);

    List<OrderEntity> getList();
}
