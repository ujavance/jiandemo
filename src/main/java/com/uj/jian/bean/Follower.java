package com.uj.jian.bean;

import java.util.Date;

public class Follower extends FollowerKey {
    private Date followtime;

    public Date getFollowtime() {
        return followtime;
    }

    public void setFollowtime(Date followtime) {
        this.followtime = followtime;
    }

    @Override
    public String toString() {
        return "Follower{" +
                "followtime=" + followtime +
                '}';
    }
}