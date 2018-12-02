package com.uj.jian.dao.impl;

import com.uj.jian.dao.RedisService;
import com.uj.jian.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisUtils redisUtils;

    public void removeDate(String key) {
        redisUtils.clearKey(key);
    }

    public <T> void savaObject(String key, T value) {
        redisUtils.setObjectToRedis(key,value);
    }

    public <T> T queryObject(String key) {
        return (T) redisUtils.getObjectFromRedis(key);
    }

    public <T> List<T> queryList(String key) {
        return (List<T>) redisUtils.getListFromRedis(key);
    }

    public <T> void savaList(String key, List<T> value) {
        redisUtils.setListToRedis(key, (List<Object>) value);
    }

    public <T> Map<String, T> queryMap(String key) {
        return (Map<String, T>) redisUtils.getMapFromRedis(key);
    }

    public <T> void savaMap(String key, Map<String, T> value) {
        redisUtils.setMapToRedis(key, (Map<String, Object>) value);
    }

    public <T> T queryObjectForMap(String key, String itemKey) {
        return (T) redisUtils.getObjectFromRedisMap(key,itemKey);
    }

    public <T> void savaObjectToMap(String key, String itemKey, T value) {
        redisUtils.setObjectToRedisMap(key,itemKey,value);
    }


}