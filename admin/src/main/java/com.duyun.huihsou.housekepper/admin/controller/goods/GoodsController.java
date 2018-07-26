package com.duyun.huihsou.housekepper.admin.controller.goods;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.duyun.huihsou.housekepper.admin.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.admin.request.CategoryParams;
import com.duyun.huihsou.housekepper.admin.service.category.CategoryService;
import com.duyun.huishou.housekeeper.po.CategoryEntity;
import org.apache.commons.collections.CollectionUtils;
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
 * @author haoshijing
 * @version 2018年05月08日 21:13
 **/
@Controller
@RequestMapping("/goods")
public class GoodsController {

    private Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private CategoryService categoryService;

    @VisitorAccessible
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "product-brand";
    }

    @VisitorAccessible
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String getList() {
        List<CategoryEntity> list = categoryService.getList();

        return JSONObject.toJSONString(list, SerializerFeature.WriteMapNullValue);
    }

    @VisitorAccessible
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model) {
        CategoryEntity entity = categoryService.selectByPrimaryKey(id);
        List<CategoryEntity> list = categoryService.selectByType();
        if (entity != null && CollectionUtils.isNotEmpty(list)) {
            model.addAttribute("entity", entity);
            model.addAttribute("list", list);
        } else {
            throw new RuntimeException("编辑失败");
        }
        return "product-add";
    }

    @VisitorAccessible
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        CategoryEntity entity = new CategoryEntity();
        List<CategoryEntity> list = categoryService.selectByType();
        model.addAttribute("entity", entity);
        model.addAttribute("list", list);
        return "product-add";
    }

    @VisitorAccessible
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(CategoryParams params) {

        CategoryEntity entity = new CategoryEntity();
        BeanUtils.copyProperties(params, entity);
        categoryService.updateByPrimaryKeySelective(entity);
        if (entity.getId() != null) {
            entity.setLastUpdateTime(System.currentTimeMillis());

        } else {
            entity.setInsertTime(System.currentTimeMillis());
            entity.setCategoryType((byte) (entity.getParentId()+1));
            categoryService.insert(entity);
        }

        return "ok";
    }

    @VisitorAccessible
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable Integer id) {
        try {
            categoryService.deleteByPrimaryKey(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return JSONObject.toJSONString("error");
        }

        return JSONObject.toJSONString("ok");
    }

}
