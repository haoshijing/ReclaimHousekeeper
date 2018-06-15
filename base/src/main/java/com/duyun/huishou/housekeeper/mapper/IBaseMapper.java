package com.duyun.huishou.housekeeper.mapper;


/**
 * @author haoshijing
 * @version 2018年01月09日 17:33
 **/

public interface IBaseMapper<T> extends IBaseDao{

    int insert(String statement, T entity);

    int updateByPrimaryKeySelective(String statement, T entity);

    int deleteByPrimaryKey(String statement, Integer id);


    T selectByPrimaryKey(String statement, Integer id);


}
