package com.duyun.huihsou.housekepper.pc.controller;

import com.alibaba.fastjson.JSON;
import com.duyun.huihsou.housekepper.pc.service.goods.GoodsService;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.constants.RetCode;
import com.duyun.huishou.housekeeper.po.ItemSkuEntity;
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
@RequestMapping("/pc/portal/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces="application/json")
    public Object save(@RequestBody ItemSkuEntity itemSkuEntity) {
        try {
            return new ApiResponse(goodsService.save(itemSkuEntity));
        }catch(Exception e) {
            //System.out.println("异常信息为："+e.getMessage());
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND,"未知错误"));
        }
    }
}
