package com.duyun.huihsou.housekepper.admin.request;

import java.io.Serializable;

public class NewsParams implements Serializable {
    private Integer id;

    private String title;

    private String content;

    private String img;

    private Integer isTop;

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
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }
}