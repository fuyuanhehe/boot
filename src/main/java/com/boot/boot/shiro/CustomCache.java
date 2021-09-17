package com.boot.boot.shiro;

import com.boot.boot.redis.RedisServiceImpl;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SerializationUtils;

import java.util.Collection;
import java.util.Set;

public class CustomCache<K, V> implements Cache<K, V> {


    @Autowired
    RedisServiceImpl<byte[]> redisService;

    @Override
    public V get(K k) throws CacheException {

        byte[] value = redisService.get(k.toString());

        V v = (V) SerializationUtils.deserialize(value);
        return v;
    }

    @Override
    public V put(K k, V v) throws CacheException {

        byte[] value = SerializationUtils.serialize(v);
        redisService.set(k.toString(), value, 3600L);
        return v;
    }

    @Override
    public V remove(K k) throws CacheException {

        V value = this.get(k);
        redisService.remove(k.toString());

        return value;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {

        return null;
    }
}
