package com.uj.jian.service;

import com.uj.jian.bean.Tag;
import com.uj.jian.bean.TagExample;
import com.uj.jian.dao.TagMapper;
import com.uj.jian.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
