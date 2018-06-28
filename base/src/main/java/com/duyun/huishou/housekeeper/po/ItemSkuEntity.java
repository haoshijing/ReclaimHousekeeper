package com.duyun.huishou.housekeeper.po;

import java.math.BigDecimal;

public class ItemSkuEntity {
    private Integer id;

    private Integer categoryId;

    private String name;

    private String attributeDetailids;

    private BigDecimal price;

    private Long insertTime;

    private Long lastUpdateTime;

    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAttributeDetailids() {
        return attributeDetailids;
    }

    public void setAttributeDetailids(String attributeDetailids) {
        this.attributeDetailids = attributeDetailids == null ? null : attributeDetailids.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Long insertTime) {
        this.insertTime = insertTime;
    }

    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}