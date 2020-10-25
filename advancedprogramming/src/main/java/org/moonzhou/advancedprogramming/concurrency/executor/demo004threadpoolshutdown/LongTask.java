package org.moonzhou.advancedprogramming.concurrency.executor.demo004threadpoolshutdown;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class LongTask implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("长时间任务");
        TimeUnit.SECONDS.sleep(5);
        return null;
    }
}