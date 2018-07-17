package com.duyun.huishou.housekeeper.mapper;

import com.duyun.huishou.housekeeper.po.CategoryEntity;
import com.duyun.huishou.housekeeper.po.category.category;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CategoryEntityMapper extends IBaseDao<CategoryEntity>{
    List<CategoryEntity> selectByParentId(Integer parentId);

    @Select("SELECT\n" +
            "t_category.id,\n" +
            "t_category.`name`,\n" +
            "t_category.icon,\n" +
            "t_category.parent_id,\n" +
            "t_category.category_type\n" +
            "FROM\n" +
            "t_category\n" +
            "\n" +
            "WHERE parent_id =#{parent_id,jdbcType=INTEGER}\n" +
            "\n" +
            "LIMIT LIMIT  #{start,jdbcType=INTEGER}, #{size,jdbcType=INTEGER}")
    List<category> getCategoryList(Map map);


    @Select("SELECT\n" +
            "COUNT(*)\n" +
            "FROM\n" +
            "t_category\n" +
            "WHERE parent_id = #{start,jdbcType=INTEGER}")
    Integer getCountFromParent(Integer id);


    List<CategoryEntity> findByParams(Map<String, Object> map);

    Integer getCount();
}