package com.uj.jian.bean;

import java.util.Date;

public class Article {
    private Integer articleid;

    private String articlehead;

    private Date articletime;

    private Integer articlereadnums;

    private Integer userid;

    private Integer tagid;

    private Integer likenum;

    private String userimg;


    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public String getArticlehead() {
        return articlehead;
    }

    public void setArticlehead(String articlehead) {
        this.articlehead = articlehead == null ? null : articlehead.trim();
    }

    public Date getArticletime() {
        return articletime;
    }

    public void setArticletime(Date articletime) {
        this.articletime = articletime;
    }

    public Integer getArticlereadnums() {
        return articlereadnums;
    }

    public void setArticlereadnums(Integer articlereadnums) {
        this.articlereadnums = articlereadnums;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }

    public Integer getLikenum() {
        return likenum;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg == null ? null : userimg.trim();
    }
}