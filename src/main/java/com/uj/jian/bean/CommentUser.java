package com.uj.jian.bean;

public class CommentUser {

    private Comment comment;
    private User user;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CommentUser{" +
                "comment=" + comment +
                ", user=" + user +
                '}';
    }
}
