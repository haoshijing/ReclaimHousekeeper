package com.duyun.huihsou.housekepper.portal.controller.category;

import com.duyun.huihsou.housekepper.portal.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.portal.service.category.CategoryService;
import com.duyun.huishou.housekeeper.ApiResponse;
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
 * @version 2018年05月08日 21:13
 **/
@RestController
@RequestMapping("/h5/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @VisitorAccessible
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces="application/json")
    public ApiResponse<List<CategoryEntity>> getList(@RequestBody Map<String, Object> map) {
        List<CategoryEntity> list = categoryService.getCategoryByParentId((Integer) map.get("parentId"));
        return new ApiResponse(list);
    }
}
