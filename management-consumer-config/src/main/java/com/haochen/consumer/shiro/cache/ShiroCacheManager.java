package com.haochen.consumer.shiro.cache;

import org.apache.shiro.cache.Cache;

/**
 * @author YangChao
 */
public interface ShiroCacheManager {

    /**
     * @param name
     * @param <K>
     * @param <V>
     * @return
     */
    <K, V> Cache<K, V> getCache(String name);

    /**
     *
     */
    void destroy();

}
