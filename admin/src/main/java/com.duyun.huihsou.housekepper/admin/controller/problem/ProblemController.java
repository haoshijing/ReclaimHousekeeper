package com.duyun.huihsou.housekepper.admin.controller.problem;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.duyun.huihsou.housekepper.admin.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.admin.request.BaseParams;
import com.duyun.huihsou.housekepper.admin.service.problem.ProblemService;
import com.duyun.huihsou.housekepper.admin.vo.ProblemVO;
import com.duyun.huishou.housekeeper.po.ProblemEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/problem")
public class ProblemController {

    private Logger logger = LoggerFactory.getLogger(ProblemController.class);
    @VisitorAccessible
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String problemListPage() {

        return "problem-list";
    }

    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    @ResponseBody
    public String problemList(){
        BaseParams baseParams = new BaseParams();
        baseParams.setPageNo(null);
        baseParams.setPageSize(null);// 不需要分页
        List<ProblemEntity> all = problemService.getAll();
        return JSONObject.toJSONString(all, SerializerFeature.WriteMapNullValue);
    }

    @VisitorAccessible
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String problemAdd() {
        return "problem-add";
    }

    @Autowired
    private ProblemService problemService;
    @VisitorAccessible
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String problemAdd1(ProblemVO problemVO) {
        try {
            problemService.addProblem(problemVO);
        }catch (Exception e) {
            logger.error(e.getMessage());
            return JSONObject.toJSONString("error");
        }
        return JSONObject.toJSONString("ok");
    }

    @VisitorAccessible
    @RequestMapping(value = "/del/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String problemDel(@PathVariable Integer id) {
        try {
            problemService.deleteByPrimaryKey(id);
        }catch (Exception e) {
            logger.error(e.getMessage());
            return JSONObject.toJSONString("error");
        }
        return JSONObject.toJSONString("ok");
    }

    @VisitorAccessible
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String problemUpdatePage(Model model, @PathVariable Integer id) {
        ProblemEntity problemEntity = problemService.selectByPrimaryKey(id);
        model.addAttribute("problem", problemEntity);
        return "problem-edit";
    }

    @VisitorAccessible
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String problemUpdate(ProblemVO problemVO) {
        ProblemEntity problemEntity = new ProblemEntity();
        problemEntity.setId(problemVO.getId());
        problemEntity.setName(problemVO.getName());
        problemEntity.setAnswer(problemVO.getAnswer());
        problemService.updateByPrimaryKeySelective(problemEntity);
        return JSONObject.toJSONString("ok");
    }
}
