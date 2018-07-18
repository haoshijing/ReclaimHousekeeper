package com.duyun.huishou.housekeeper.mapper;

import com.duyun.huishou.housekeeper.po.ProblemEntity;
import com.duyun.huishou.housekeeper.po.problem.problemItem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface ProblemEntityMapper extends IBaseDao<ProblemEntity>{
    List<ProblemEntity> getAll();

    List<ProblemEntity> selectAll(Map<String,Object> map);

    //查找问题通过id 查找
    @Select("SELECT\n" +
            "t_problem.id,\n" +
            "t_problem.`name`,\n" +
            "t_problem.answer\n" +
            "FROM\n" +
            "t_problem\n" +
            "\n" +
            "WHERE t_problem.id= #{id,jdbcType=INTEGER}")
    problemItem getProbleByID(Map map);

    //得到所有的问题分页
    @Select("SELECT\n" +
            "t_problem.id,\n" +
            "t_problem.`name`,\n" +
            "t_problem.answer\n" +
            "FROM\n" +
            "t_problem\n" +
            "ORDER BY\n" +
            "t_problem.last_update_time DESC \n" +
            "LIMIT  #{start,jdbcType=INTEGER}, #{size,jdbcType=INTEGER}")
    List<problemItem> getAllProblem(Map map);

    //通过主键删除 问题
    @Delete("delete from t_problem \n" +
            "where id = #{id,jdbcType=INTEGER}")
    Integer delectOneByProble(Integer id);

    //更新语句
    @Update("UPDATE `t_problem` \n" +
            "SET `name`= #{name,jdbcType=VARCHAR}, \n" +
            "`answer`= #{answer,jdbcType=VARCHAR}, \n" +
            "`last_update_time`= #{lastUpdateTime,jdbcType=BIGINT}, \n" +

            " WHERE (`id`=#{id,jdbcType=INTEGER}) LIMIT 1")
    Integer updateProble(Map map);

    @Override
    int insert(ProblemEntity entity);

    @Select("select count(*) from t_problem")
    int getCountProblem();

}