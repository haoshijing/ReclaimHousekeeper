package com.duyun.huihsou.housekepper.pc.service.news;

import com.duyun.huihsou.housekepper.pc.service.AbstractBaseService;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
import com.duyun.huishou.housekeeper.mapper.NewsEntityMapper;
import com.duyun.huishou.housekeeper.po.NewsEntity;
import com.duyun.huishou.housekeeper.po.news.newSummary;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class NewsServiceImpl extends AbstractBaseService<NewsEntity> implements NewsService{

    /**
     *
     */
    @Autowired
    private NewsEntityMapper newsEntityMapper;

    @Override
    public IBaseDao getMapper() {
        return newsEntityMapper;
    }


    // 获取新闻 按照最后时间排序  是否置顶
    @Override
    public List<newSummary> getNewsprofile(Map map) {
        return newsEntityMapper.getNewsprofile(map);
    }


    @Override
    public NewsEntity selectByPrimaryKey(Integer id){
        return  newsEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertOneNewPage(NewsEntity newsEntity) {
        return newsEntityMapper.insert(newsEntity);
    }

    @Override
    public int StickNewsPage(Map map) {
        return newsEntityMapper.StickPage(map);
    }

    @Override
    public int updateByPrimaryKeySelective(NewsEntity entity){
        return newsEntityMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int deleteNewsByPageId(Integer id) {
        return newsEntityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int getCountNews() {
        return newsEntityMapper.getCountNews();
    }


}
