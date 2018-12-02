package com.uj.jian.service;

import com.uj.jian.bean.Tag;
import com.uj.jian.bean.TagExample;
import com.uj.jian.dao.TagMapper;
import com.uj.jian.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagMapper tagMapper;

    /*
    根据tagName，查询tag集合
    * */
    public List<Tag> getTags(String tagName){
        if (tagName == null || tagName.isEmpty()) {
            return null;
        }
        TagExample tagExample = new TagExample();
        TagExample.Criteria criteria =  tagExample.createCriteria();
        criteria.andTagnameLike(new StringBuilder().append("%").append(tagName).append("%").toString());
        return tagMapper.selectByExample(tagExample);
    }

    public boolean create(String tagname) {
        if (tagname == null || tagname.length() < 2) {
            return false;
        } else if (find(tagname)) {
            return false;
        } else {
            Tag tag = new Tag();
            tag.setTagcreatetime(new Date());
            tag.setTagname(tagname);
            return tagMapper.insert(tag) > 0;
        }
    }

    public boolean find(String tagname) {
        if (tagname == null || tagname.length() < 2) {
            return false;
        }
        TagExample tagExample = new TagExample();
        TagExample.Criteria criteria = tagExample.createCriteria();
        criteria.andTagnameEqualTo(tagname);
        return tagMapper.selectByExample(tagExample).size() > 0;
    }

    public long getTagOfUser(final  Integer userId){
        // select count( DISTINCT tagId) from tbl_article where userId = 1
        return tagMapper.selectTagNumOfArticle(userId);
    }

    public long getArticleNum(final  Integer userId){
        // select count( DISTINCT tagId) from tbl_article where userId = 1
        return tagMapper.selectUserArticleNumber(userId);
    }
}
