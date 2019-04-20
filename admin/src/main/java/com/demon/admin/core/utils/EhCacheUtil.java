package com.demon.admin.core.utils;

import com.demon.core.utils.SpringContextUtil;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

/**
 * EhCache缓存操作工具
 * @Author: oneperfect
 * @Date: 2019/4/11
 */
public class EhCacheUtil {

    /**
     * 获取CacheManager管理对象
     */
    public static CacheManager getCacheManager() {
        return SpringContextUtil.getBean(CacheManager.class);
    }

    /**
     * 获取Cache缓存对象
     */
    public static Cache getCache(String name) {
        return getCacheManager().getCache(name);
    }

    /**
     * 获取字典缓存对象
     */
    public static Cache getDictCache() {
        return getCacheManager().getCache("dictionary");
    }
}
