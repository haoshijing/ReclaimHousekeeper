package com.duyun.huihsou.housekepper.portal.controller.attribute;

import com.duyun.huihsou.housekepper.portal.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.portal.service.attribute.AttributeService;
import com.duyun.huihsou.housekepper.portal.vo.AttributeInfoVO;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.po.AttributeDetailEntity;
import com.duyun.huishou.housekeeper.po.AttributeEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
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
    public ApiResponse<List<AttributeEntity>> getList(@RequestBody Map<String, Object> map) {
        List<AttributeEntity> list = attributeService.getAttributeByCategoryId((Integer) map.get("categoryId"));
        List<AttributeInfoVO> attributeInfoVOList = new ArrayList<>();
        list.forEach(obj->{
            AttributeInfoVO attributeInfoVO = new AttributeInfoVO();
            BeanUtils.copyProperties(obj, attributeInfoVO);

            Map<String, Object> param = new HashMap<>();
            param.put("attributeId", obj.getId());
            List<AttributeDetailEntity> attributeDetailEntityList = attributeService.getAttributeDetailByCondetion(param);
            attributeInfoVO.setAttributeDetailEntityList(attributeDetailEntityList);
            attributeInfoVOList.add(attributeInfoVO);
        });
        return new ApiResponse(attributeInfoVOList);
    }

    @VisitorAccessible
    @RequestMapping(value = "/detail/list", method = RequestMethod.POST, produces="application/json")
    public ApiResponse<List<AttributeDetailEntity>> getDetailList(@RequestBody Map<String, Object> map) {
        List<AttributeDetailEntity> list = attributeService.getAttributeDetailByCondetion(map);
        return new ApiResponse(list);
    }
}
