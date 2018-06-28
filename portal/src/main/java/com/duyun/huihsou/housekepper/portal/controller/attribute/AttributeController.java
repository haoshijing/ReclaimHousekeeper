package com.duyun.huihsou.housekepper.portal.controller.attribute;

import com.duyun.huihsou.housekepper.portal.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.portal.service.attribute.AttributeService;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.po.AttributeDetailEntity;
import com.duyun.huishou.housekeeper.po.AttributeEntity;
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
@RequestMapping("/h5/api/attribute")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @VisitorAccessible
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces="application/json")
    public ApiResponse<Boolean> getList(@RequestBody Map<String, Object> map) {
        List<AttributeEntity> list = attributeService.getAttributeByCategoryId((Integer) map.get("categoryId"));
        return new ApiResponse(list);
    }

    @VisitorAccessible
    @RequestMapping(value = "/detail/list", method = RequestMethod.POST, produces="application/json")
    public ApiResponse<Boolean> getDetailList(@RequestBody Map<String, Object> map) {
        List<AttributeDetailEntity> list = attributeService.getAttributeDetailByCondetion(map);
        return new ApiResponse(list);
    }
}
