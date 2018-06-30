package com.duyun.huishou.housekeeper.mapper;

import com.duyun.huishou.housekeeper.po.NewsEntity;

import com.duyun.huishou.housekeeper.po.news.newSummary;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;
import java.util.Map;

public interface NewsEntityMapper extends IBaseDao<NewsEntity>{

    // 显示文章概括
    @Select("SELECT * FROM ( \n"+
            "SELECT \n"+
            "t_news.id, \n"+
            "t_news.content, \n"+
            "t_news.title, \n"+
            "t_news.is_top  isTop, \n"+
            "t_news.last_update_time  lastUpdateTime \n"+
            "FROM \n"+
            "t_news \n"+
            "GROUP BY t_news.id \n"+
            "ORDER BY \n"+
            "t_news.last_update_time DESC \n"+
            ") AS news \n"+
            "ORDER BY news.isTop DESC \n"+
            "LIMIT  #{start,jdbcType=INTEGER}, #{size,jdbcType=INTEGER}")
    List<newSummary> getNewsprofile(Map map);

    @Select("select count(*) from t_news")
    int getCountNews();

    // 查找具体一篇文章  通过主键查找一篇文章
    @Override
    NewsEntity selectByPrimaryKey(Integer id);

    // 插入一篇文章
    @Override
    int insert(NewsEntity entity);

    @Update("UPDATE `t_news` SET `is_top`='1' WHERE (`id`= #{id,jdbcType=INTEGER}) LIMIT 1")
    int StickPage(Map map);

    @Override
    int updateByPrimaryKeySelective(NewsEntity entity);

    @Override
    int deleteByPrimaryKey(Integer id);

    List<NewsEntity> selectAll(Map<String, Object> map);

}