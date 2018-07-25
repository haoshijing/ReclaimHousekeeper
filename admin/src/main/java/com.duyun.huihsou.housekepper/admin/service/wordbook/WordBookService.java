package com.duyun.huihsou.housekepper.admin.service.wordbook;


import com.duyun.huihsou.housekepper.admin.service.IBaseService;
import com.duyun.huishou.housekeeper.po.UserEntity;
import com.duyun.huishou.housekeeper.po.WordBookEntity;

import java.util.List;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */
public interface WordBookService extends IBaseService<WordBookEntity> {

    List<WordBookEntity> getList();
}
