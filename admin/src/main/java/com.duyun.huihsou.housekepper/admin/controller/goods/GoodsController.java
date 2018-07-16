package com.duyun.huihsou.housekepper.admin.controller.goods;

import com.duyun.huihsou.housekepper.admin.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.admin.request.BaseParams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author haoshijing
 * @version 2018年05月08日 21:13
 **/
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @VisitorAccessible
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getList(BaseParams params) {

        return "product-brand";
    }
}
