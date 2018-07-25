package com.duyun.huishou.housekeeper.mapper;

import com.duyun.huishou.housekeeper.po.BannerConfigEntity;
import com.duyun.huishou.housekeeper.po.ProblemEntity;
import com.duyun.huishou.housekeeper.po.banner.bannerR;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface BannerConfigEntityMapper extends IBaseDao<BannerConfigEntity>{

    List<BannerConfigEntity> selectByCondition(BannerConfigEntity entity);

    @Select("SELECT\n" +
            "t_banner_config.id,\n" +
            "t_banner_config.icon,\n" +
            "t_banner_config.title\n" +
            "FROM\n" +
            "t_banner_config\n" +
            "WHERE\n" +
            "t_banner_config.`status`=#{status,jdbcType=INTEGER}  AND\n" +
            "t_banner_config.channel=#{channel,jdbcType=INTEGER}\n " +
            "LIMIT  #{start,jdbcType=INTEGER}, #{size,jdbcType=INTEGER}")
    List<bannerR> selectItem(Map map);

    @Override
    int insert(BannerConfigEntity entity);

    @Select("select count(*) from t_banner_config")
    int getCountbanner();

    @Delete("delete from t_banner_config\n" +
            "    where id = #{id,jdbcType=INTEGER}")
    int delectOneBanprom(Integer id);


    List<BannerConfigEntity> getList();
}