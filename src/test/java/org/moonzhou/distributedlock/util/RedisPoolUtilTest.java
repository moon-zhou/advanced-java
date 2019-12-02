package org.moonzhou.distributedlock.util;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import static org.junit.Assert.*;

public class RedisPoolUtilTest {

    public static final String OK = "OK";
    String firstKey = "moon";
    String firstVal = "handSomeBoy";

    @Test
    public void easyTest() {
        Jedis jedis = new Jedis();

        // 本地Redis服务状态，返回PONG--->正常
        String pingResult = jedis.ping();
        assertEquals("PONG", pingResult);


        String moonSetResult = jedis.set(firstKey, firstVal);
        assertEquals(OK, moonSetResult);

        String moonResult = jedis.get(firstKey);
        assertEquals(firstVal, moonResult);
    }

    @Test
    public void test() {
        RedisPoolUtil.setnx(firstKey, firstVal);

        String moonVal = RedisPoolUtil.get(firstKey);

        assertEquals(firstVal, moonVal);
    }

}