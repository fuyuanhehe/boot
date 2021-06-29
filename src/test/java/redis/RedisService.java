package redis;/*
package com.boot.boot.service;

public interface RedisService <T> {
	
	*/
/**
     * 写入缓存
     * @param key
     * @param value
     * @return
     *//*

    public boolean set(final String key, T value);
    
    */
/**
     * 写入缓存设置时效时间
     * @param key
     * @param value
     * @return
     *//*

    public boolean set(final String key, T value, Long expireTime);
    
    */
/**
     * 读取缓存
     * @param key
     * @return
     *//*

    public T get(final String key);
    
    */
/**
     * 批量删除对应的value
     * @param keys
     *//*

    public void remove(final String... keys);
    
    */
/**
     * 批量删除key
     * @param pattern
     *//*

    public void removePattern(final String pattern);
    
    */
/**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     *//*

    public boolean exists(final String key);
}
*/
