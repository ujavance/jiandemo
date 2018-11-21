package com.uj.jian.test;

import com.uj.jian.bean.Tag;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaTest {

    @Test
    public  void  testJava8(){
        List<Tag> followerList = new LinkedList<>();
        Tag tag1 = new Tag();
        tag1.setTagid(1);Tag tag2 = new Tag();
        tag2.setTagid(1);Tag tag3 = new Tag();
        tag3.setTagid(1);Tag tag4 = new Tag();
        tag4.setTagid(1);
        followerList.add(tag1);
        followerList.add(tag2);
        followerList.add(tag3);
        followerList.add(tag4);
        List<Integer> appleMap3 = followerList.stream().map(tag -> tag.getTagid()).collect(Collectors.toList());
        appleMap3.stream().forEach(System.out::println);
    }
}
