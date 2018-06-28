package com.duyun.huihsou.housekepper.pc.controller;

import com.alibaba.fastjson.JSON;
import com.duyun.huihsou.housekepper.pc.service.category.CategoryService;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.constants.RetCode;
import com.duyun.huishou.housekeeper.po.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author haoshijing
 * @version 2018年05月23日 20:54
 **/

@RestController
@RequestMapping("/pc/portal/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces="application/json")
    public Object getList(@RequestBody Map<String, Object> map) {
        try{
            List<CategoryEntity> list = categoryService.getCategoryByParentId((Integer) map.get("parentId"));
            return  JSON.toJSON(new ApiResponse(list));
        }catch(Exception e) {
            //System.out.println("异常信息为："+e.getMessage());
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND,"请求失败或没有数据"));
        }
    }

}
