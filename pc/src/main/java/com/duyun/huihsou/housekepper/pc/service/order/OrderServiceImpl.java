package com.duyun.huihsou.housekepper.pc.service.order;

import com.duyun.huihsou.housekepper.pc.service.AbstractBaseService;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
import com.duyun.huishou.housekeeper.mapper.OrderEntityMapper;
import com.duyun.huishou.housekeeper.po.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends AbstractBaseService<OrderEntity> implements OrderService  {

    @Autowired
    private OrderEntityMapper orderEntityMapper;

    @Override
    public IBaseDao getMapper() {
        return orderEntityMapper;
    }
}
