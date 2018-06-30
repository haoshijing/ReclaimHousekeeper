package com.duyun.huihsou.housekepper.portal.controller.problem;

import com.duyun.huihsou.housekepper.portal.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.portal.request.BaseParams;
import com.duyun.huihsou.housekepper.portal.response.ProblemVO;
import com.duyun.huihsou.housekepper.portal.service.problem.ProblemService;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.po.CategoryEntity;
import com.duyun.huishou.housekeeper.po.ProblemEntity;
import com.duyun.huishou.housekeeper.util.PageUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoshijing
 * @version 2018年05月08日 21:13
 **/
@RestController
@RequestMapping("/h5/api/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @VisitorAccessible
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces="application/json")
    public ApiResponse<List<CategoryEntity>> getList(@RequestBody BaseParams params) {
        List<ProblemEntity> problemEntityList = problemService.getAll(params);
        List<ProblemVO> list = new ArrayList<>();
        problemEntityList.forEach(obj->{
            ProblemVO vo = new ProblemVO();
            BeanUtils.copyProperties(obj,vo);
            list.add(vo);
        });
        PageUtils pageUtils = new PageUtils(list,0, params.getPageSize(), params.getPageNo());
        return new ApiResponse(pageUtils);
    }
}
