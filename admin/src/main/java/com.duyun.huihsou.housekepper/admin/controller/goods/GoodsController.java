package com.duyun.huihsou.housekepper.admin.controller.goods;

import com.duyun.huihsou.housekepper.admin.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.admin.request.BaseParams;
import com.duyun.huihsou.housekepper.admin.request.CategoryParams;
import com.duyun.huihsou.housekepper.admin.service.category.CategoryService;
import com.duyun.huihsou.housekepper.admin.vo.CategoryVO;
import com.duyun.huishou.housekeeper.po.CategoryEntity;
import com.duyun.huishou.housekeeper.util.PageUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoshijing
 * @version 2018年05月08日 21:13
 **/
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private CategoryService categoryService;

    @VisitorAccessible
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getList(BaseParams params, Model model) {
        List<CategoryEntity> categoryServiceList = categoryService.getList(params);
        List<CategoryVO> list = new ArrayList<>();
        categoryServiceList.forEach(obj->{
            CategoryVO categoryVO = new CategoryVO();
            BeanUtils.copyProperties(obj, categoryVO);
            list.add(categoryVO);
        });
        Integer count = categoryService.getNum();
        PageUtils pageUtils = new PageUtils(list,count, params.getPageSize(), params.getPageNo());
        model.addAttribute("pageUtils",pageUtils);
        return "product-brand";
    }

    @VisitorAccessible
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Integer id, Model model) {
        CategoryEntity entity = categoryService.selectByPrimaryKey(id);
        model.addAttribute("entity", entity);
        return "product-brand";
    }

    @VisitorAccessible
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String save(CategoryParams params, Model model) {

        CategoryEntity entity = new CategoryEntity();
        BeanUtils.copyProperties(params, entity);
        if (entity.getId()!=null){
            categoryService.updateByPrimaryKeySelective(entity);
        } else {
            categoryService.insert(entity);
        }
        model.addAttribute("entity", entity);
        return "product-brand";
    }

    @VisitorAccessible
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(Integer id) {
        categoryService.deleteByPrimaryKey(id);
        return "product-brand";
    }
}
