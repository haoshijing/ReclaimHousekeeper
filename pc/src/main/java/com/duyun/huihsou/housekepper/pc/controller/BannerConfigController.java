package com.duyun.huihsou.housekepper.pc.controller;

import com.alibaba.fastjson.JSON;
import com.duyun.huihsou.housekepper.pc.service.banner.BannerConfigService;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.constants.RetCode;
import com.duyun.huishou.housekeeper.po.BannerConfigEntity;
import com.duyun.huishou.housekeeper.po.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pc/portal/banner")
public class BannerConfigController {

    @Autowired
    private BannerConfigService bannerConfigService;

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces="application/json")
    public Object getList(@RequestBody BannerConfigEntity entity) {
        try {
            return JSON.toJSON(new ApiResponse(bannerConfigService.getBannerConfigByConfition(entity)));
        }catch(Exception e) {
            //System.out.println("异常信息为："+e.getMessage());
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND,"请求失败或没有数据"));
        }

    }

}
