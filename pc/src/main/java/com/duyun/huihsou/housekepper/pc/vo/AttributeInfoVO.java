package com.duyun.huihsou.housekepper.pc.vo;

import com.duyun.huishou.housekeeper.po.AttributeDetailEntity;

import java.util.List;

public class AttributeInfoVO {
    private Integer id;

    private Integer categoryId;

    private Integer parentId;

    private String attributeName;

    private List<AttributeDetailEntity> attributeDetailEntityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public List<AttributeDetailEntity> getAttributeDetailEntityList() {
        return attributeDetailEntityList;
    }

    public void setAttributeDetailEntityList(List<AttributeDetailEntity> attributeDetailEntityList) {
        this.attributeDetailEntityList = attributeDetailEntityList;
    }
}
