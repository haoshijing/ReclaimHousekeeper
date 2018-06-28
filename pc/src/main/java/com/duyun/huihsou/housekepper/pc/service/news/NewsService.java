package com.duyun.huihsou.housekepper.pc.service.news;


import com.duyun.huihsou.housekepper.pc.service.IBaseService;
import com.duyun.huishou.housekeeper.po.NewsEntity;
import com.duyun.huishou.housekeeper.po.news.newSummary;

import java.util.List;
import java.util.Map;

public interface NewsService extends IBaseService<NewsEntity> {


   List<newSummary> getNewsprofile(Map map);

   NewsEntity selectByPrimaryKey(Integer id);

   int insertOneNewPage(NewsEntity newsEntity);

   int StickNewsPage(Map map);

   int updateByPrimaryKeySelective(NewsEntity entity);

   int deleteNewsByPageId(Integer id);

   int getCountNews();

}
