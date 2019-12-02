package org.moonzhou.distributedlock.util;

import redis.clients.jedis.Jedis;

/**
 * redis常规操作
 *
 * @author moon zhou
 * @date 2019-12-01
 */
public class RedisPoolUtil {

    private RedisPoolUtil() {
    }

    private static RedisPool redisPool;

    public static String get(String key) {
        Jedis jedis = null;
        String result = null;

        try {
            jedis = RedisPool.getJedisResource();
            result = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();

            return result;
        }
    }

    public static Long setnx(String key, String value) {
        Jedis jedis = null;
        Long result = null;

        try {
            jedis = RedisPool.getJedisResource();
            result = jedis.setnx(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();

            return result;
        }
    }

    public static String getSet(String key, String value) {
        Jedis jedis = null;
        String result = null;

        try {
            jedis = RedisPool.getJedisResource();
            result = jedis.getSet(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();

            return result;
        }
    }

    public static Long expire(String key, int seconds) {
        if(seconds <= 0){
            return 0L;
        }

        Jedis jedis = null;
        Long result = null;

        try {
            jedis = RedisPool.getJedisResource();
            result = jedis.expire(key, seconds);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();

            return result;
        }
    }

    public static Long del(String key) {
        Jedis jedis = null;
        Long result = null;

        try {
            jedis = RedisPool.getJedisResource();
            result = jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();

            return result;
        }
    }
}
