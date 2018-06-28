package com.duyun.huihsou.housekepper.pc.controller;


import com.alibaba.fastjson.JSON;
import com.duyun.huihsou.housekepper.pc.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class menuController {

    @Autowired
    private NewsService newsService;

    /**
     *  得到所有的菜单
     *
     * @param code
     * @return   【object，object】
     */
    @RequestMapping(value = "/get_m1enuList", method = RequestMethod.GET)
    public Object getMenuList(String code){
        System.out.println("2222");


        return null;
    }



}
