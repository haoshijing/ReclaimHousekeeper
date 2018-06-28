package com.duyun.huihsou.housekepper.portal.service;

import com.duyun.huishou.housekeeper.aop.NameSpace;
import com.duyun.huishou.housekeeper.mapper.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBaseService<T> implements IBaseService<T> {
    @Autowired
    private IBaseMapper iBaseMapper;

    public AbstractBaseService() {
    }

    private String getNameSpace() {
        NameSpace nameSpace = (NameSpace)this.getClass()
                .getAnnotation(NameSpace.class);
        return nameSpace.value();
    }

    @Override
    public int updateByPrimaryKeySelective(T entity) {
        return this.iBaseMapper.updateByPrimaryKeySelective(this.getNameSpace(), entity);
    }

    @Override
    public int insert(T entity) {
        return iBaseMapper.insert(this.getNameSpace(), entity);
    }


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return iBaseMapper.deleteByPrimaryKey(this.getNameSpace(), id);
    }

    @Override
    public T selectByPrimaryKey(Integer id) {
        return (T)iBaseMapper.selectByPrimaryKey(this.getNameSpace(), id);
    }
}
