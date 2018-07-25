package com.duyun.huihsou.housekepper.admin.service.wordbook;


import com.duyun.huihsou.housekepper.admin.service.AbstractBaseService;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
import com.duyun.huishou.housekeeper.mapper.UserEntityMapper;
import com.duyun.huishou.housekeeper.mapper.WordBookEntityMapper;
import com.duyun.huishou.housekeeper.po.UserEntity;
import com.duyun.huishou.housekeeper.po.WordBookEntity;
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
public class WordBookServiceImpl extends AbstractBaseService<WordBookEntity> implements WordBookService {

    @Autowired
    private WordBookEntityMapper wordBookEntityMapper;

    @Override
    public IBaseDao getMapper() {
        return (IBaseDao)wordBookEntityMapper;
    }

    @Override
    public List<WordBookEntity> getList() {
        return wordBookEntityMapper.getList();
    }
}
