package redis;/*
package redis;

public interface RedisService <T> {
	
	*/
/**
     * 写入缓存
     * @param key
     * @param value
     * @return
     *//*

     boolean set(final Object key, T value);
    
    */
/**
     * 写入缓存设置时效时间
     * @param key
     * @param value
     * @return
     *//*

     boolean set(final Object key, T value, Long expireTime);
    
    */
/**
     * 读取缓存
     * @param key
     * @return
     *//*

     T get(final Object key);
    
    */
/**
     * 批量删除对应的value
     * @param keys
     *//*

     void remove(final Object... keys);
    
    */
/**
     * 批量删除key
     * @param pattern
     *//*

     void removePattern(final Object pattern);
    
    */
/**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     *//*

     boolean exists(final Object key);
}
*/
