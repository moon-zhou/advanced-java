package org.moonzhou.lock.impl;

import org.moonzhou.lock.IDistributedLock;

import java.util.concurrent.TimeUnit;

/**
 * @Description 分布式锁的实现方式之一：缓存-redis
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/7/28
 */
public class RedisDistributedLock implements IDistributedLock {


    @Override
    public void lock() {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }
}
