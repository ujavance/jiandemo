package com.uj.jian.bean;

public class FollowerKey {
    private Integer userid;

    private Integer followid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getFollowid() {
        return followid;
    }

    public void setFollowid(Integer followid) {
        this.followid = followid;
    }

    @Override
    public String toString() {
        return "FollowerKey{" +
                "userid=" + userid +
                ", followid=" + followid +
                '}';
    }
}