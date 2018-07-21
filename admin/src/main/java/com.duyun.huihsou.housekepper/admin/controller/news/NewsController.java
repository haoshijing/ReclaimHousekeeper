package com.duyun.huihsou.housekepper.admin.controller.news;

import com.duyun.huihsou.housekepper.admin.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.admin.request.BaseParams;
import com.duyun.huihsou.housekepper.admin.service.news.NewsService;
import com.duyun.huishou.housekeeper.po.NewsEntity;
import com.duyun.huishou.housekeeper.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author haoshijing
 * @version 2018年05月08日 21:13
 **/
@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @VisitorAccessible
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getList(BaseParams params) {
        List<NewsEntity> list = newsService.getAll(params);
        Integer count = newsService.getNum();
        PageUtils pageUtils = new PageUtils(list,count, params.getPageSize(), params.getPageNo());
        return "index";
    }

    @VisitorAccessible
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        NewsEntity entity = new NewsEntity();
        model.addAttribute("entity", entity);
        return "article-add";
    }
}
