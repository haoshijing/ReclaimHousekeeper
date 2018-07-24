package com.duyun.huishou.housekeeper.mapper;


/**
 * @author haoshijing
 * @version 2018年01月09日 17:33
 **/

public interface IBaseDao<T>{

    int insert(T entity);

    int insertSelective(T entity);

    int updateByPrimaryKeySelective(T entity);

    int deleteByPrimaryKey(Integer id);


    T selectByPrimaryKey(Integer id);


}
