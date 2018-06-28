package com.duyun.huihsou.housekepper.pc.controller;

import com.alibaba.fastjson.JSON;
import com.duyun.huihsou.housekepper.pc.service.order.OrderService;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.constants.RetCode;
import com.duyun.huishou.housekeeper.po.OrderEntity;
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
@RequestMapping("/pc/portal/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces="application/json")
    public Object save(@RequestBody OrderEntity orderEntity) {
        try {
            if (orderEntity.getId() == null) {
                orderEntity.setInsertTime(System.currentTimeMillis());
                orderEntity.setLastUpdateTime(System.currentTimeMillis());
                orderService.insert(orderEntity);
            } else {
                orderEntity.setLastUpdateTime(System.currentTimeMillis());
                orderService.updateByPrimaryKeySelective(orderEntity);
            }
            return JSON.toJSON(new ApiResponse());

        }catch(Exception e) {
            System.out.println("异常信息为："+e.getMessage());
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND,"请求失败或没有数据"));
        }

    }
}
