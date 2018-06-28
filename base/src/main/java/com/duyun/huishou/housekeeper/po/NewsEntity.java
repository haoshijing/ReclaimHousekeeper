package com.duyun.huishou.housekeeper.po;

import lombok.Data;

@Data
public class NewsEntity {

    //没有重新构造img 函数
    // 重写构造方法
    public NewsEntity(Integer id,String title,String content,Byte isTop,Long insertTime,Long lastUpdateTime){
        setId(id);
        setContent(content);
        setTitle(title);
        setIsTop(isTop);
        setLastUpdateTime(lastUpdateTime);
        setInsertTime(insertTime);
    }

   

    private Integer id;

    private String title;

    private String content;
    private String img;

    private Byte isTop;

    private Long insertTime;

    private Long lastUpdateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Byte getIsTop() {
        return isTop;
    }

    public void setIsTop(Byte isTop) {
        this.isTop = isTop;
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