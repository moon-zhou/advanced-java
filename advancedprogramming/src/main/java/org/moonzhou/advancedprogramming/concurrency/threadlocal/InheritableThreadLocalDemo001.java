/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: InheritableThreadLocalDemo.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/5/18 19:22
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.concurrency.threadlocal;

/**
 * 功能描述: InheritableThreadLocal使用示例<br>
 *     子线程可以拿到父线程设置的InheritableThreadLocal值，也可以自己设置InheritableThreadLocal值，自己获取
 *     但是子线程设置的InheritableThreadLocal值，父线程是获取不到的
 *
 *     <p>根本原因还是子线程复制了父线程的InheritableThreadLocal值，本身的引用是与线程一一关联。
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class InheritableThreadLocalDemo001 {
    private static InheritableThreadLocal<String> INHERITABLE_THREAD_LOCAL = new InheritableThreadLocal();

    private static ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        INHERITABLE_THREAD_LOCAL.set("父线程中使用 InheritableThreadLocal 设置变量");
        THREAD_LOCAL.set("父线程中使用 ThreadLocal 设置变量");

        Thread thread = new Thread(
                () -> {
                    System.out.println("-------子线程获取结果------");
                    // 能拿到设置的变量
                    System.out.println("从 InheritableThreadLocal 拿父线程设置的变量: " + INHERITABLE_THREAD_LOCAL.get());
                    // 打印为 null
                    System.out.println("从 ThreadLocal 拿父线程设置的变量: " + THREAD_LOCAL.get());

                    // 子线程重新设置值
                    INHERITABLE_THREAD_LOCAL.set("子线程中使用 InheritableThreadLocal 设置变量");
                    THREAD_LOCAL.set("子线程中使用 ThreadLocal 设置变量");

                    // 均能拿到在子线程里设置的值
                    System.out.println("从 InheritableThreadLocal 拿父线程设置的变量: " + INHERITABLE_THREAD_LOCAL.get());
                    System.out.println("从 ThreadLocal 拿父线程设置的变量: " + THREAD_LOCAL.get());
                }
        );

        thread.start();
        thread.join();

        // 均能获取到父线程设置的值，无法获取到子线程设置的值
        System.out.println("-------主线程获取结果-------");
        System.out.println("从 InheritableThreadLocal 拿父线程设置的变量: " + INHERITABLE_THREAD_LOCAL.get());
        System.out.println("从 ThreadLocal 拿父线程设置的变量: " + THREAD_LOCAL.get());

        System.out.println("end...");
    }
}
