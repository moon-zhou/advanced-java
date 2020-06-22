package org.moonzhou.advancedprogramming.concurrency.threaddemo.threadjoin;

/**
 * 测试主线程-子线程-孙子线程的多层join
 *
 * @author moon-zhou
 * @date 2020/6/22 11:52
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ParentChildrenGrandSonThread {
    public static void main(String[] args) {
        System.out.println("start main...");

        Children1Thread children1Thread = new Children1Thread();
        children1Thread.start();

        /**
         * 此代码块执行与否，影响的是主线程以此往后的执行，
         *
         * 有此行，主线程会在此挂起suspend，最后的字符输出完当前main线程执行完成，全部线程执行结束
         * 无此行，主线程不挂起，直接运行后面的输出，主线程优先执行结束
         */
        try {
            children1Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main done...");

    }
}
