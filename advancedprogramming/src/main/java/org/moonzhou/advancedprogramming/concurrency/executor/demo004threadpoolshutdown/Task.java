package org.moonzhou.advancedprogramming.concurrency.executor.demo004threadpoolshutdown;

import java.util.concurrent.Callable;

public class Task implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("普通任务");
        return null;
    }
}