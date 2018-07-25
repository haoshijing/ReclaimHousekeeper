package com.duyun.huihsou.housekepper.admin.controller.banner;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.duyun.huihsou.housekepper.admin.controller.member.MemberController;
import com.duyun.huihsou.housekepper.admin.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.admin.request.UserParams;
import com.duyun.huihsou.housekepper.admin.service.banner.BannerConfigService;
import com.duyun.huihsou.housekepper.admin.service.wordbook.WordBookService;
import com.duyun.huishou.housekeeper.po.BannerConfigEntity;
import com.duyun.huishou.housekeeper.po.CategoryEntity;
import com.duyun.huishou.housekeeper.po.WordBookEntity;
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
@RequestMapping("/banner")
public class BannerController {

    private Logger logger = LoggerFactory.getLogger(BannerController.class);

    @Autowired
    private BannerConfigService bannerConfigService;

    @VisitorAccessible
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "banner-list";
    }

    @VisitorAccessible
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String getList() {
        List<BannerConfigEntity> list = bannerConfigService.getList();

        return JSONObject.toJSONString(list, SerializerFeature.WriteMapNullValue);
    }

    @VisitorAccessible
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model) {
        BannerConfigEntity entity = bannerConfigService.selectByPrimaryKey(id);
        if (entity!=null){
            model.addAttribute("entity", entity);
        }
        return "banner-add";
    }
    @VisitorAccessible
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add( Model model) {
        BannerConfigEntity entity = new BannerConfigEntity();
        model.addAttribute("entity", entity);
        return "banner-add";
    }
    @VisitorAccessible
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(UserParams params) {

        BannerConfigEntity entity = new BannerConfigEntity();
        BeanUtils.copyProperties(params, entity);
        if (entity.getId()!=null){
            bannerConfigService.updateByPrimaryKeySelective(entity);
        } else {
            bannerConfigService.insert(entity);
        }

        return JSONObject.toJSONString(true);
    }

    @VisitorAccessible
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable Integer id) {
        try {
            bannerConfigService.deleteByPrimaryKey(id);
        }catch (Exception e) {
            logger.error(e.getMessage());
            return JSONObject.toJSONString("error");
        }

        return JSONObject.toJSONString("ok");
    }
}
