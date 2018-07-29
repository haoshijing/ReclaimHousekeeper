package com.duyun.huihsou.housekepper.admin.service.problem;


import com.duyun.huihsou.housekepper.admin.service.AbstractBaseService;
import com.duyun.huihsou.housekepper.admin.vo.ProblemVO;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
import com.duyun.huishou.housekeeper.mapper.ProblemEntityMapper;
import com.duyun.huishou.housekeeper.po.ProblemEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */

@Service
@Slf4j
public class ProblemServiceImpl extends AbstractBaseService<ProblemEntity> implements ProblemService {

    @Autowired
    private ProblemEntityMapper problemEntityMapper;


    @Override
    public IBaseDao getMapper() {
        return problemEntityMapper;
    }

    @Override
    public List<ProblemEntity> getAll() {
        return problemEntityMapper.getAll();
    }



    @Override
    public void addProblem(ProblemVO problemVO) {
        ProblemEntity problemEntity = new ProblemEntity();
        problemEntity.setName(problemVO.getName());
        problemEntity.setAnswer(problemVO.getAnswer());
        problemEntity.setInsertTime(System.currentTimeMillis());
        problemEntity.setLastUpdateTime(System.currentTimeMillis());
        problemEntityMapper.insert(problemEntity);
    }

}
