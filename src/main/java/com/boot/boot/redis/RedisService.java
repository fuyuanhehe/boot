package com.boot.boot.redis;


interface RedisService<T> {

    boolean set(final String key, T value);

    boolean set(final String key, T value, Long expireTime);

    T get(final String key);

    void remove(final String... keys);

    void removePattern(final String pattern);

    boolean exists(final String key);
}

