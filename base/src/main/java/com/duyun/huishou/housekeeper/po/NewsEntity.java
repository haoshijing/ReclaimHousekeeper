package com.duyun.huishou.housekeeper.po;

import lombok.Data;

@Data
public class NewsEntity {

    //默认构造方法
    public NewsEntity(){}


    // 重写构造方法
    public NewsEntity(Integer id,String title,String content,Integer isTop,Long insertTime,Long lastUpdateTime,String img){
        setId(id);
        setContent(content);
        setTitle(title);
        setIsTop(isTop);
        setLastUpdateTime(lastUpdateTime);
        setInsertTime(insertTime);
        setImg(img);

    }

    //重写构造方法
    public NewsEntity(Integer id,String title,String content,Integer isTop,Long lastUpdateTime,String img){
        setId(id);
        setContent(content);
        setTitle(title);
        setIsTop(isTop);
        setLastUpdateTime(lastUpdateTime);
        setImg(img);
    }


    private Integer id;

    private String title;

    private String content;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    private String img;

    private Integer isTop;

    private Long insertTime;

    private Long lastUpdateTime;

    private Integer type;

    private String newsDate;

    private String newsAuther;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsAuther() {
        return newsAuther;
    }

    public void setNewsAuther(String newsAuther) {
        this.newsAuther = newsAuther;
    }

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

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
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