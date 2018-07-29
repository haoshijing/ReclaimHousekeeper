package com.duyun.huihsou.housekepper.admin.controller.news;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.duyun.huihsou.housekepper.admin.controller.order.OrderController;
import com.duyun.huihsou.housekepper.admin.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.admin.request.BaseParams;
import com.duyun.huihsou.housekepper.admin.request.NewsParams;
import com.duyun.huihsou.housekepper.admin.service.news.NewsService;
import com.duyun.huishou.housekeeper.po.CategoryEntity;
import com.duyun.huishou.housekeeper.po.NewsEntity;
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
@RequestMapping("/news")
public class NewsController {
    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private NewsService newsService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String getList(BaseParams params) {
        List<NewsEntity> list = newsService.getAll(params);
        return JSONObject.toJSONString(list, SerializerFeature.WriteMapNullValue);
    }


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        NewsEntity entity = new NewsEntity();
        model.addAttribute("entity", entity);
        return "article-list";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model) {
        NewsEntity entity = newsService.selectByPrimaryKey(id);
        if (entity!=null){
            model.addAttribute("entity", entity);
        }
        return "article-add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add( Model model) {
        NewsEntity entity = new NewsEntity();
        model.addAttribute("entity", entity);
        return "article-add";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody NewsParams params) {

        NewsEntity entity = new NewsEntity();
        BeanUtils.copyProperties(params, entity);
        if (entity.getId()!=null){
            newsService.updateByPrimaryKeySelective(entity);
        } else {
            newsService.insertSelective(entity);
        }

        return JSONObject.toJSONString(true);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable Integer id) {
        try {
            newsService.deleteByPrimaryKey(id);
        }catch (Exception e) {
            logger.error(e.getMessage());
            return JSONObject.toJSONString("error");
        }

        return JSONObject.toJSONString("ok");
    }
}
