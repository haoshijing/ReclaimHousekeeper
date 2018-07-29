package com.duyun.huihsou.housekepper.admin.controller.banner;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.duyun.huihsou.housekepper.admin.request.BannerChannelParams;
import com.duyun.huihsou.housekepper.admin.service.banner.BannerChannelService;
import com.duyun.huishou.housekeeper.po.BannerChannelEntity;
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
@RequestMapping("/banner/channel")
public class BannerChannelController {

    private Logger logger = LoggerFactory.getLogger(BannerChannelController.class);

    @Autowired
    private BannerChannelService bannerChannelService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "bannerchannel-list";
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String getList() {
        List<BannerChannelEntity> list = bannerChannelService.getList();

        return JSONObject.toJSONString(list, SerializerFeature.WriteMapNullValue);
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model) {
        BannerChannelEntity entity = bannerChannelService.selectByPrimaryKey(id);
        if (entity!=null){
            model.addAttribute("entity", entity);
        }
        return "bannerchannel-add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add( Model model) {
        BannerChannelEntity entity = new BannerChannelEntity();
        model.addAttribute("entity", entity);
        return "bannerchannel-add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(BannerChannelParams params) {

        BannerChannelEntity entity = new BannerChannelEntity();
        BeanUtils.copyProperties(params, entity);
        if (entity.getId()!=null){
            bannerChannelService.updateByPrimaryKeySelective(entity);
        } else {
            bannerChannelService.insert(entity);
        }

        return JSONObject.toJSONString(true);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable Integer id) {
        try {
            bannerChannelService.deleteByPrimaryKey(id);
        }catch (Exception e) {
            logger.error(e.getMessage());
            return JSONObject.toJSONString("error");
        }

        return JSONObject.toJSONString("ok");
    }
}
