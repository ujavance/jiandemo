package com.uj.jian.bean;

public class ArticleDO {

    private Integer  tagId;
    private Integer userId;
    private String content;

    @Override
    public String toString() {
        return "ArticleDO{" +
                "tagId=" + tagId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
