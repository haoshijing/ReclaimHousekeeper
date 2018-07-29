package com.duyun.huihsou.housekepper.admin.controller.news;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.duyun.huihsou.housekepper.admin.controller.order.OrderController;
import com.duyun.huihsou.housekepper.admin.request.NewsTypeParams;
import com.duyun.huihsou.housekepper.admin.service.news.NewsTypeService;
import com.duyun.huishou.housekeeper.po.NewsTypeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author haoshijing
 * @version 2018年05月08日 21:13
 **/
@Controller
@RequestMapping("/news/type")
public class NewsTypeController {
    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private NewsTypeService newsTypeService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String getList() {
        List<NewsTypeEntity> list = newsTypeService.getAll();
        return JSONObject.toJSONString(list, SerializerFeature.WriteMapNullValue);
    }


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        NewsTypeEntity entity = new NewsTypeEntity();
        model.addAttribute("entity", entity);
        return "articletype-list";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model) {
        NewsTypeEntity entity = newsTypeService.selectByPrimaryKey(id);
        if (entity!=null){
            model.addAttribute("entity", entity);
        }
        return "articletype-add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add( Model model) {
        NewsTypeEntity entity = new NewsTypeEntity();
        model.addAttribute("entity", entity);
        return "articletype-add";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(NewsTypeParams params) {

        NewsTypeEntity entity = new NewsTypeEntity();
        BeanUtils.copyProperties(params, entity);
        if (entity.getId()!=null){
            newsTypeService.updateByPrimaryKeySelective(entity);
        } else {
            newsTypeService.insertSelective(entity);
        }

        return JSONObject.toJSONString(true);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable Integer id) {
        try {
            newsTypeService.deleteByPrimaryKey(id);
        }catch (Exception e) {
            logger.error(e.getMessage());
            return JSONObject.toJSONString("error");
        }

        return JSONObject.toJSONString("ok");
    }
}
