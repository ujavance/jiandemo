package com.uj.jian.bean;

import java.util.Date;

public class Tag {
    private Integer tagid;

    private String tagname;

    private Date tagcreatetime;

    private Integer tagarticlenumbers;

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname == null ? null : tagname.trim();
    }

    public Date getTagcreatetime() {
        return tagcreatetime;
    }

    public void setTagcreatetime(Date tagcreatetime) {
        this.tagcreatetime = tagcreatetime;
    }

    public Integer getTagarticlenumbers() {
        return tagarticlenumbers;
    }

    public void setTagarticlenumbers(Integer tagarticlenumbers) {
        this.tagarticlenumbers = tagarticlenumbers;
    }
}