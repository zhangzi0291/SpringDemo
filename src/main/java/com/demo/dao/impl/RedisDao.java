package com.demo.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;


@Component("RedisDao")
@SuppressWarnings({"hiding","unchecked"})
public  class RedisDao<T> {
    
    @Resource
    RedisTemplate<String, T> redisTemplate;

    public <T> void setValue(String key, T value) {
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(value.getClass()));
        ValueOperations<String, T> operation = (ValueOperations<String, T>) redisTemplate.opsForValue(); 
        operation.set(key, value);
    }

    public <T> T getValue(String key) {
        ValueOperations<String, T> operation = (ValueOperations<String, T>) redisTemplate.opsForValue(); 
        return operation.get(key);
    }

    public <T> void setListValue(String key, List<T> list) {
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(list.get(0).getClass()));
        ListOperations<String, T> operation = (ListOperations<String, T>) redisTemplate.opsForList();
        redisTemplate.delete(key);
        operation.rightPushAll(key, list);
    }
    
    public <T> void appendListValue(String key, List<T> list) {
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(list.get(0).getClass()));
        ListOperations<String, T> operation = (ListOperations<String, T>) redisTemplate.opsForList();
        operation.rightPushAll(key, list);
    }

    public <T> List<T> getListValue(String key) {
        ListOperations<String, T> operation = (ListOperations<String, T>) redisTemplate.opsForList();
        List<T> list = operation.range(key, 0L, operation.size(key));
        return list;
    }

}
