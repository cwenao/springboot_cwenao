/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.dbserver.handler.validator;

import org.springframework.cache.Cache;

/**
 * @author cwenao
 * @version $Id AbstractCacheSupport.java, v 0.1 2017-01-29 15:35 cwenao Exp $$
 */
public abstract class AbstractCacheSupport {

    /**
     * 获取缓存内容
     * @param cache
     * @param key
     * @return
     */
    protected Object getFromCache(Cache cache, String key) {
        final Cache.ValueWrapper valueWrapper = cache.get(key);
        return null == valueWrapper ? null : valueWrapper.get();
    }

    /**
     * 设置缓存数据
     * @param cache
     * @param key
     * @param value
     * @return
     */
    protected boolean putCache(Cache cache, String key, Object value) {
        if (null == value) {
            return false;
        }
        cache.put(key, value);

        return true;
    }

    /**
     * 删除缓存数据
     * @param cache
     * @param key
     * @return
     */
    protected boolean evictFromCache(Cache cache,Object key){
        if(null == key){
            return false;
        }
        cache.evict(key);

        return true;
    }
}

