package com.duyun.huihsou.housekepper.portal.vo;

import java.math.BigDecimal;

public class ItemSkuVO {

    private Integer id;

    private Integer categoryId;

    private String content;

    private String attributeDetailids;

    private BigDecimal price;

    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public ItemSkuVO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public ItemSkuVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public ItemSkuVO setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ItemSkuVO setContent(String content) {
        this.content = content;
        return this;
    }

    public String getAttributeDetailids() {
        return attributeDetailids;
    }

    public ItemSkuVO setAttributeDetailids(String attributeDetailids) {
        this.attributeDetailids = attributeDetailids == null ? null : attributeDetailids.trim();
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemSkuVO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
    
}