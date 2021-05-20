/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: InheritableThreadLocalDemo002.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/5/20 15:36
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.concurrency.threadlocal;

/**
 * 功能描述: InheritableThreadLocal使用示例<br>
 *     子线程可以拿到父线程设置的InheritableThreadLocal，其中子线程可以是儿子，也可以孙子，及嵌套多层时，内层的线程可以获取到外层的线程设置的InheritableThreadLocal值
 *     InheritableThreadLocal也具备同线程的使用特性，同ThreadLocal
 *     子线程设置的InheritableThreadLocal值，父线程是无法获取到的。即内部线程设置的InheritableThreadLocal，外部线程无法获取到。
 *
 *     <p>根本原因还是子线程复制了父线程的InheritableThreadLocal值，本身的引用是与线程一一关联。
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class InheritableThreadLocalDemo002 {
    private static InheritableThreadLocal<String> INHERITABLE_THREAD_LOCAL = new InheritableThreadLocal();

    public static void main(String[] args) throws InterruptedException {
        INHERITABLE_THREAD_LOCAL.set("Thread main: moon");

        // 创建儿子线程
        Thread thread = new Thread(() -> {

            // 创建孙子线程
            Thread thread1 = new Thread(() -> {
                System.out.println("孙子线程: " + Thread.currentThread().getName() + " 从InheritableThreadLocal 拿到 main 线程设置的值："
                        + INHERITABLE_THREAD_LOCAL.get());
            }, "grand child 0");

            thread1.start();
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            // 儿子线程获取main线程中的 InheritableThreadLocal
            System.out.println("儿子线程: " + Thread.currentThread().getName() + " 从InheritableThreadLocal 拿到 main 线程设置的值："
                    + INHERITABLE_THREAD_LOCAL.get());

            // 儿子线程修改 InheritableThreadLocal
            INHERITABLE_THREAD_LOCAL.set("Thread child: moonmoon");


            // 创建孙子线程
            Thread thread2 = new Thread(() -> {
                System.out.println("孙子线程: " + Thread.currentThread().getName() + " 从InheritableThreadLocal 拿到 child 线程设置的值："
                        + INHERITABLE_THREAD_LOCAL.get());
            }, "grand child 1");

            thread2.start();
            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }, "child");

        thread.start();
        thread.join();

        // 主线程获取 InheritableThreadLocal
        System.out.println("main线程: " + Thread.currentThread().getName() + " 从InheritableThreadLocal 拿到 main(自己) 线程设置的值："
                + INHERITABLE_THREAD_LOCAL.get());

        System.out.println("main execute end...");
    }
}
