package com.duyun.huishou.housekeeper.mapper;

import com.duyun.huishou.housekeeper.dto.OrderDTO;
import com.duyun.huishou.housekeeper.po.OrderEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderEntityMapper extends IBaseDao<OrderEntity>{
    List<OrderDTO> getOrderInfo(@Param("userId") Integer userId, @Param("orderStatus")Integer orderStatus);

    List<OrderEntity> getList();
}