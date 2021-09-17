package com.boot.boot.redis;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;


@Service
public class RedisServiceImpl<T> implements RedisService<T> {

    Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

    @Autowired
    private RedisTemplate<Object, T> redisTemplate;

/*
redisTemplate.opsForValue();//操作字符串
redisTemplate.opsForHash();//操作hash
redisTemplate.opsForList();//操作list
redisTemplate.opsForSet();//操作set
redisTemplate.opsForZSet();//操作有序set
*/

    @Override
    public boolean set(String key, T value) {
        boolean result = false;
        try {
            ValueOperations<Object, T> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;



        } catch (Exception e) {
            logger.error("设置redis异常", e);
        }
        return result;
    }

    @Override
    public boolean set(String key, T value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Object, T> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            logger.error("设置redis异常", e);
        }
        return result;
    }

    @Override
    public T get(String key) {
        T result = null;

        try {
            ValueOperations<Object, T> operations = redisTemplate.opsForValue();

            result = operations.get(key);
        } catch (Exception e) {
            logger.error("获得redis异常", e);
        }
        return result;
    }

    @Override
    public void remove(String... keys) {
        for (String key : keys) {
            if (exists(key)) {
                redisTemplate.delete(key);
            }
        }

    }

    @Override
    public void removePattern(String pattern) {
        Set<Object> keys = redisTemplate.keys(pattern);
        if (!keys.isEmpty()) {
            redisTemplate.delete(keys);
        }
    }

    @Override
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }
}
