package com.duyun.huihsou.housekepper.portal.service;

import com.duyun.huishou.housekeeper.aop.NameSpace;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;

public abstract class AbstractBaseService<T> implements IBaseService<T> {

    public AbstractBaseService() {
    }

    public abstract IBaseDao getMapper();

    private String getNameSpace() {
        NameSpace nameSpace = (NameSpace)this.getClass()
                .getAnnotation(NameSpace.class);
        return nameSpace.value();
    }

    @Override
    public int updateByPrimaryKeySelective(T entity) {
        return this.getMapper().updateByPrimaryKeySelective(entity);
    }

    @Override
    public int insert(T entity) {
        return this.getMapper().insert(entity);
    }


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.getMapper().deleteByPrimaryKey(id);
    }

    @Override
    public T selectByPrimaryKey(Integer id) {
        return (T)this.getMapper().selectByPrimaryKey(id);
    }
}
