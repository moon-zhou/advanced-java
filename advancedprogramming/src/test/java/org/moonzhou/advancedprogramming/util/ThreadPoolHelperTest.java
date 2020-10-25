package org.moonzhou.advancedprogramming.util;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class ThreadPoolHelperTest {

    /**
     * 成功关闭
     */
    @Test
    public void test() {
        ThreadPoolHelper.executeTask(()->{
            System.out.println("task1 in..");
            System.out.println("task1 end..");
        });
        ThreadPoolHelper.executeTask(()->{
            System.out.println("task2 in..");
            System.out.println("task2 end..");
        });
        ThreadPoolHelper.executeTask(()->{
            System.out.println("task3 in..");
            System.out.println("task3 end..");
        });

        // 保证任务，可以直接关闭
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ThreadPoolHelper.shutdown();
    }

    /**
     * 没有直接关闭掉，等了3秒的上线时间之内，关闭了
     */
    @Test
    public void test1() {
        ThreadPoolHelper.executeTask(()->{
            System.out.println("task1 in..");
            System.out.println("task1 end..");
        });
        ThreadPoolHelper.executeTask(()->{
            System.out.println("task2 in..");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task2 end..");
        });
        ThreadPoolHelper.executeTask(()->{
            System.out.println("task3 in..");
            System.out.println("task3 end..");
        });

        ThreadPoolHelper.shutdown();
    }

    /**
     * 规定时间之内还未关闭掉，强制shutdownNow
     */
    @Test
    public void test2() {
        ThreadPoolHelper.executeTask(()->{
            System.out.println("task1 in..");
            System.out.println("task1 end..");
        });
        ThreadPoolHelper.executeTask(()->{
            System.out.println("task2 in..");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task2 end..");
        });
        ThreadPoolHelper.executeTask(()->{
            System.out.println("task3 in..");
            System.out.println("task3 end..");
        });

        ThreadPoolHelper.shutdown();
    }

    /**
     * 自定义关闭成功的等待超时时间
     */
    @Test
    public void test3() {
        ThreadPoolHelper.executeTask(()->{
            System.out.println("task1 in..");
            System.out.println("task1 end..");
        });
        ThreadPoolHelper.executeTask(()->{
            System.out.println("task2 in..");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task2 end..");
        });
        ThreadPoolHelper.executeTask(()->{
            System.out.println("task3 in..");
            System.out.println("task3 end..");
        });

        ThreadPoolHelper.shutdown(8);
    }

}