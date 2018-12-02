package com.uj.jian.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 清空指定key的记录
     */
    public void clearKey(String key){
        redisTemplate.delete(key);
    }

    /**
     * 从redis读取一个对象数据
     */
    public Object getObjectFromRedis(String key){
        BoundValueOperations<String,Object> boundValueOperations = redisTemplate.boundValueOps(key);
        return boundValueOperations.get();
    }

    /**
     * 向redis写入一个列表数据
     */
    public void setObjectToRedis(String key,Object value){
        BoundValueOperations<String,Object> boundValueOperations = redisTemplate.boundValueOps(key);
        boundValueOperations.set(value);
    }

    /**
     * 从redis读取一个列表数据
     */
    public List<Object> getListFromRedis(String key){
        BoundListOperations<String,Object> boundValueOperations = redisTemplate.boundListOps(key);
        return boundValueOperations.range(0,boundValueOperations.size());
    }

    /**
     * 向redis写入一个对象数据
     */
    public void setListToRedis(String key,List<Object> value){
        BoundListOperations<String,Object> boundValueOperations = redisTemplate.boundListOps(key);
        boundValueOperations.rightPushAll(value);
    }


    /**
     * 从redis读取一个map数据
     */
    public Map<String, Object> getMapFromRedis(String key){
        BoundHashOperations<String,String,Object> boundValueOperations = redisTemplate.boundHashOps(key);
        return boundValueOperations.entries();
    }

    /**
     * 向redis写入一个map数据
     */
    public void setMapToRedis(String key, Map<String, Object> value){
        BoundHashOperations<String,String,Object> boundValueOperations = redisTemplate.boundHashOps(key);
        boundValueOperations.putAll(value);
    }


    /**
     * 从redis总读取指定map的一个key的值
     */
    public Object getObjectFromRedisMap(String key,String hkey){
        BoundHashOperations<String,String,Object> boundValueOperations = redisTemplate.boundHashOps(key);
        return boundValueOperations.get(hkey);
    }

    /**
     * 向redis中指定的map写入一个key,value
     */
    public void setObjectToRedisMap(String key,String hkey,Object value){
        BoundHashOperations<String,String,Object> boundValueOperations = redisTemplate.boundHashOps(key);
        boundValueOperations.put(hkey,value);
    }

}