package com.uj.jian.dao;

import com.uj.jian.bean.Follower;
import com.uj.jian.bean.FollowerExample;
import com.uj.jian.bean.FollowerKey;
import java.util.List;

import com.uj.jian.bean.User;
import org.apache.ibatis.annotations.Param;

public interface FollowerMapper {
    long countByExample(FollowerExample example);

    int deleteByExample(FollowerExample example);

    int deleteByPrimaryKey(FollowerKey key);

    int insert(Follower record);

    int insertSelective(Follower record);

    List<Follower> selectByExample(FollowerExample example);


    List<User> selectByFenNumRecommond(Integer num, Integer userid);

    Follower selectByPrimaryKey(FollowerKey key);



    int updateByExampleSelective(@Param("record") Follower record, @Param("example") FollowerExample example);

    int updateByExample(@Param("record") Follower record, @Param("example") FollowerExample example);

    int updateByPrimaryKeySelective(Follower record);

    int updateByPrimaryKey(Follower record);
}