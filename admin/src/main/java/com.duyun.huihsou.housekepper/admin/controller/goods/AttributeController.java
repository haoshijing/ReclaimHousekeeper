package com.duyun.huihsou.housekepper.admin.controller.goods;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.duyun.huihsou.housekepper.admin.request.AttributeParams;
import com.duyun.huihsou.housekepper.admin.request.CategoryParams;
import com.duyun.huihsou.housekepper.admin.service.attribute.AttributeService;
import com.duyun.huishou.housekeeper.exception.ApplicationException;
import com.duyun.huishou.housekeeper.po.AttributeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 许志武
 * @Date: on 2018/8/7
 */

@Controller
@RequestMapping("/attribute")
public class AttributeController {

    private Logger logger = LoggerFactory.getLogger(AttributeController.class);

    @Autowired
    private AttributeService attributeService;

    @RequestMapping(value = "/index/{categoryId}", method = RequestMethod.GET)
    public String index(@PathVariable Integer categoryId, Model model) {
        model.addAttribute("categoryId", categoryId);
        return "product-attribute";
    }

    @RequestMapping(value = "/list/{categoryId}", method = RequestMethod.GET)
    @ResponseBody
    public String getList(@PathVariable Integer categoryId) {
        List<AttributeEntity> list = attributeService.getAttributeByCategoryId(categoryId);

        return JSONObject.toJSONString(list, SerializerFeature.WriteMapNullValue);
    }


    @RequestMapping(value = "/edit/{categoryId}/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer categoryId, @PathVariable Integer id, Model model) {
        AttributeEntity entity = attributeService.selectByPrimaryKey(id);
        if (entity != null) {
            model.addAttribute("entity", entity);
            model.addAttribute("categoryId", categoryId);
        } else {
            throw new ApplicationException("编辑失败");
        }
        return "product-attribute-add";
    }


    @RequestMapping(value = "/add/{categoryId}", method = RequestMethod.GET)
    public String add(@PathVariable Integer categoryId, Model model) {
        AttributeEntity entity = new AttributeEntity();
        model.addAttribute("entity", entity);
        model.addAttribute("categoryId", categoryId);
        return "product-attribute-add";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(AttributeParams params) {

        AttributeEntity entity = new AttributeEntity();
        BeanUtils.copyProperties(params, entity);
        entity.setLastUpdateTime(System.currentTimeMillis());
        if (entity.getId() != null) {
            attributeService.updateByPrimaryKeySelective(entity);

        } else {
            entity.setInsertTime(System.currentTimeMillis());
            attributeService.insert(entity);
        }

        return "ok";
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable Integer id) {
        try {
            attributeService.deleteByPrimaryKey(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return JSONObject.toJSONString("error");
        }

        return JSONObject.toJSONString("ok");
    }

}