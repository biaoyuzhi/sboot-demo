package com.example.sbootdemo.common;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wuzh on 2018/9/21.
 */
public class Cache {
    private static final ConcurrentHashMap<String,Object> OBJECT_CACHE = new ConcurrentHashMap<>(1024);

    public static Object getCache(String key){
        return OBJECT_CACHE.get(key);
    }
    public static void putCache(String key,Object object){
        OBJECT_CACHE.put(key,object);
    }
    public static Object removeCache(String key){
        return OBJECT_CACHE.remove(key);
    }
    public ConcurrentHashMap getMap(){
        return OBJECT_CACHE;
    }
}
