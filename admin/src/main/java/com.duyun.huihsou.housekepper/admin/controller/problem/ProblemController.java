package com.duyun.huihsou.housekepper.admin.controller.problem;

import com.duyun.huihsou.housekepper.admin.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.admin.service.problem.ProblemService;
import com.duyun.huihsou.housekepper.admin.vo.ProblemVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String problemList() {

        return "problem-list";
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
            return "error";
        }
        return "ok";
    }


}
