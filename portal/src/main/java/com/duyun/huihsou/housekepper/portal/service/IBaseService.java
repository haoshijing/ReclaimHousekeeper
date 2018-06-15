package com.duyun.huihsou.housekepper.portal.service;


/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */
public interface IBaseService<T> {

    int insert(T entity);

    int updateByPrimaryKeySelective(T entity);

    int deleteByPrimaryKey(Integer id);

    T selectByPrimaryKey(Integer id);
}
