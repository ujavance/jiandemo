package com.uj.jian.bean;

import java.util.Date;

public class Comment {
    private Integer commentid;

    private String commentbody;

    private Date commentcreatetime;

    private Integer articleid;

    private Integer userid;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public String getCommentbody() {
        return commentbody;
    }

    public void setCommentbody(String commentbody) {
        this.commentbody = commentbody == null ? null : commentbody.trim();
    }

    public Date getCommentcreatetime() {
        return commentcreatetime;
    }

    public void setCommentcreatetime(Date commentcreatetime) {
        this.commentcreatetime = commentcreatetime;
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}