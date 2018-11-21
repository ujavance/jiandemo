package com.uj.jian.bean;

public class ArticleWithBLOBsAndUser extends ArticleWithBLOBs {
    private User user;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ArticleWithBLOBsAndUser{" +
                "user=" + user +
                '}';
    }
}
