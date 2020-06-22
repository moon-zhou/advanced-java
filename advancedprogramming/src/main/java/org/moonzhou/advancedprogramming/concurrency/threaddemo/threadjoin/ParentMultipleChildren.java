package org.moonzhou.advancedprogramming.concurrency.threaddemo.threadjoin;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/6/22 15:34
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ParentMultipleChildren {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start main...");

        Children1Thread children1Thread = new Children1Thread();
        children1Thread.start();

        /**
         * 此代码块执行与否，影响的是主线程以此往后的执行，
         *
         * 有此行，主线程会在此挂起suspend
         * 无此行，主线程不挂起，直接往下运行后面的语句
         */
        children1Thread.join();


        Children2Thread children2Thread = new Children2Thread();
        children2Thread.start();

        /**
         * 此行整体逻辑与26行一致，如果26行不挂起，这里挂起，那么children1Thread的执行就是单纯的多线程执行，结果不影响主线程
         *
         */
        children2Thread.join();


        System.out.println("main done...");
    }
}
