package com.lance.blog.util;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

/**
 * @author Lance
 * @date 2018/3/9 16:11
 */
public class RedisUtils {

    private static Jedis jedis;

    static {
        // TODO: 2018/3/9 获取配置信息
        jedis = new Jedis();
    }

    private RedisUtils() {
    }

    public static <T> boolean set(String key, T value) {
        if (isNotEmpty(key) && null != value) {
            String jsonVal = new Gson().toJson(value);
            jedis.set(key, jsonVal);
            return true;
        }
        return false;
    }

    public static <T> T get(String key, Class<T> klass) {
        if (isNotEmpty(key)) {
            String jsonVal = jedis.get(key);
            T obj = new Gson().fromJson(jsonVal, klass);
            if (null != obj) {
                return obj;
            }
        }
        return null;
    }

    public static boolean remove(String key) {
        if (isNotEmpty(key)) {
            jedis.del(key);
            return true;
        }
        return false;
    }

    private static boolean isNotEmpty(String str) {
        return null != str && !"".equals(str);
    }
}
