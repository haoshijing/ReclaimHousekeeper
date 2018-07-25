package com.duyun.huihsou.housekepper.admin.controller.wordbook;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.duyun.huihsou.housekepper.admin.controller.member.MemberController;
import com.duyun.huihsou.housekepper.admin.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.admin.request.BaseParams;
import com.duyun.huihsou.housekepper.admin.request.UserParams;
import com.duyun.huihsou.housekepper.admin.request.WordBookParams;
import com.duyun.huihsou.housekepper.admin.service.problem.ProblemService;
import com.duyun.huihsou.housekepper.admin.service.user.UserService;
import com.duyun.huihsou.housekepper.admin.service.wordbook.WordBookService;
import com.duyun.huihsou.housekepper.admin.vo.ProblemVO;
import com.duyun.huishou.housekeeper.po.CategoryEntity;
import com.duyun.huishou.housekeeper.po.ProblemEntity;
import com.duyun.huishou.housekeeper.po.UserEntity;
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
@RequestMapping("/wordbook")
public class WordBookController {

    private Logger logger = LoggerFactory.getLogger(WordBookController.class);

    @Autowired
    private WordBookService wordBookService;

    @VisitorAccessible
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "wordbook-list";
    }

    @VisitorAccessible
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String getList() {
        List<WordBookEntity> list = wordBookService.getList();

        return JSONObject.toJSONString(list, SerializerFeature.WriteMapNullValue);
    }

    @VisitorAccessible
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model) {
        WordBookEntity entity = wordBookService.selectByPrimaryKey(id);
        if (entity!=null){
            model.addAttribute("entity", entity);
        }
        return "wordbook-add";
    }

    @VisitorAccessible
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add( Model model) {
        WordBookEntity entity = new WordBookEntity();
        model.addAttribute("entity", entity);
        return "wordbook-add";
    }

    @VisitorAccessible
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(WordBookParams params) {

        WordBookEntity entity = new WordBookEntity();
        BeanUtils.copyProperties(params, entity);
        if (entity.getId()!=null){
            wordBookService.updateByPrimaryKeySelective(entity);
        } else {
            wordBookService.insertSelective(entity);
        }

        return JSONObject.toJSONString(true);
    }

    @VisitorAccessible
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable Integer id) {
        try {
            wordBookService.deleteByPrimaryKey(id);
        }catch (Exception e) {
            logger.error(e.getMessage());
            return JSONObject.toJSONString("error");
        }

        return JSONObject.toJSONString("ok");
    }
}
