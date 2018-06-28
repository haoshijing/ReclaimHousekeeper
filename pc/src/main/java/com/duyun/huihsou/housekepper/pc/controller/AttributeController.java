package com.duyun.huihsou.housekepper.pc.controller;


import com.alibaba.fastjson.JSON;
import com.duyun.huihsou.housekepper.pc.service.attribute.AttributeService;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.constants.RetCode;
import com.duyun.huishou.housekeeper.po.AttributeDetailEntity;
import com.duyun.huishou.housekeeper.po.AttributeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pc/portal/attribute")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;


    @RequestMapping(value = "/list", method = RequestMethod.GET, produces="application/json")
    public Object getList(@RequestBody Map<String, Object> map) {
        try {

            List<AttributeEntity> list = attributeService.getAttributeByCategoryId((Integer) map.get("categoryId"));

            return JSON.toJSON(new ApiResponse(list));
        } catch(Exception e) {
           // System.out.println("异常信息为："+e.getMessage());
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND,"请求失败或没有数据"));
        }
    }

    @RequestMapping(value = "/detail/list", method = RequestMethod.GET, produces="application/json")
    public Object getDetailList(@RequestBody Map<String, Object> map) {
        try {
            List<AttributeDetailEntity> list = attributeService.getAttributeDetailByCondetion(map);
            return new ApiResponse(list);
        }catch(Exception e) {
            System.out.println("异常信息为："+e.getMessage());
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND,"请求失败或没有数据"));
        }
    }

}
