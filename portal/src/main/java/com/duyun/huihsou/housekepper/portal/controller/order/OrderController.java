package com.duyun.huihsou.housekepper.portal.controller.order;

import com.duyun.huihsou.housekepper.portal.gloabal.GlobalHolder;
import com.duyun.huihsou.housekepper.portal.service.order.OrderService;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.po.OrderEntity;
import com.duyun.huishou.housekeeper.po.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haoshijing
 * @version 2018年05月08日 21:13
 **/
@RestController
@RequestMapping("/h5/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces="application/json")
    public ApiResponse<Boolean> save(@RequestBody OrderEntity orderEntity) {
        UserEntity entity = GlobalHolder.getCurrentLoginUser();
        orderEntity.setUserId(entity.getId());
        if (orderEntity.getId() == null) {
            orderEntity.setInsertTime(System.currentTimeMillis());
            orderEntity.setLastUpdateTime(System.currentTimeMillis());
            orderService.insert(orderEntity);
        } else {
            orderEntity.setLastUpdateTime(System.currentTimeMillis());
            orderService.updateByPrimaryKeySelective(orderEntity);
        }
        return new ApiResponse();
    }
}
