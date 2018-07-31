package com.duyun.huihsou.housekepper.portal.controller.news;

import com.duyun.huihsou.housekepper.portal.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.portal.request.BaseParams;
import com.duyun.huihsou.housekepper.portal.request.NewsParams;
import com.duyun.huihsou.housekepper.portal.service.news.NewsService;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.constants.RetCode;
import com.duyun.huishou.housekeeper.po.CategoryEntity;
import com.duyun.huishou.housekeeper.po.NewsEntity;
import com.duyun.huishou.housekeeper.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author haoshijing
 * @version 2018年05月08日 21:13
 **/
@RestController
@RequestMapping("/h5/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @VisitorAccessible
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces="application/json")
    public ApiResponse<List<CategoryEntity>> getList(@RequestBody NewsParams params) {
        if (params.getType()==null) {
            return  new ApiResponse(RetCode.ERROR_PARAMS, "必填参数不能为空！");
        }
        List<NewsEntity> list = newsService.getAll(params);
        Integer count = newsService.getNum();
        PageUtils pageUtils = new PageUtils(list,count, params.getPageSize(), params.getPageNo());
        return new ApiResponse(pageUtils);
    }
}
