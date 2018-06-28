package com.duyun.huishou.housekeeper.po;

public class PointLogEntity {
    private Integer id;

    private Integer userId;

    private Integer beforePoint;

    private Integer afterPoint;

    private String reason;

    private Long insertTime;

    private Long lastUpdateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBeforePoint() {
        return beforePoint;
    }

    public void setBeforePoint(Integer beforePoint) {
        this.beforePoint = beforePoint;
    }

    public Integer getAfterPoint() {
        return afterPoint;
    }

    public void setAfterPoint(Integer afterPoint) {
        this.afterPoint = afterPoint;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
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