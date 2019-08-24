package org.moonzhou.lock;

import java.util.concurrent.TimeUnit;

/**
 * @Description 分布式锁定义接口类，参考jdk的Lock接口
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/7/28
 */
public interface IDistributedLock {

    /**
     * 加锁
     */
    void lock();

    /**
     * 尝试加锁
     * @return
     */
    boolean tryLock();

    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;

    /**
     * 释放锁
     */
    void unlock();
}
