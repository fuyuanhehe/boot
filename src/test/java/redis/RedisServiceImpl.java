package redis;/*
package redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

*/
/**
 * 
 * @author syao
 * redis 实用工具
 *//*

@Service
public class RedisServiceImpl<T> implements RedisService <T> {
	
	Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

    @Autowired
    private RedisTemplate<Object,T> redisTemplate;

	@Override
	public boolean set(Object key, T value) {
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
	public boolean set(Object key, T value, Long expireTime) {
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
	public T get(Object key) {
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
	public void remove(Object... keys) {
        for (Object key : keys) {
        	if (exists(key)) {
                redisTemplate.delete(key);
            }
        }
		
	}

	@Override
	public void removePattern(Object pattern) {
        Set<Object> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
	}

	@Override
	public boolean exists(Object key) {
		  return redisTemplate.hasKey(key);
	}
}*/
