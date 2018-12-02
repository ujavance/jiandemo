package com.uj.jian.dao;

import java.util.List;
import java.util.Map;

/**
 * redis服务接口
 */
public interface RedisService {

    //移除是通用的
    void removeDate(String key);


    //对象类型
    <T> void savaObject(String key,T value);

    <T> T queryObject(String key);


    //列表类型
    <T> List<T> queryList(String key);
    <T> void savaList(String key,List<T> value);

    //map类型数据,我规定map只能使用字符串做key
    <T> Map<String,T> queryMap(String key);
    <T> void savaMap(String key, Map<String,T> value);
    <T> T queryObjectForMap(String key,String itemKey);
    <T> void savaObjectToMap(String key,String itemKey, T value);
}