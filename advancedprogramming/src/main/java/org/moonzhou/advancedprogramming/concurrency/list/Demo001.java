package org.moonzhou.advancedprogramming.concurrency.list;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * list里的并发问题<br>
 *     https://juejin.im/post/5ea01672f265da47bc592370
 *     https://www.cnblogs.com/myseries/p/10877420.html
 *
 * @author moon-zhou
 * @date: 2020/4/23 08:42
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001 {

    public static void main(String[] args) {

        // 测试并发问题的list
        //listFailFast();

        // Vector解决list并发问题测试
        //concurrencyListOfVector();

        // 通过Collections.synchronizedList解决list并发问题测试
        //collectionInitSynList();

        // 通过CopyOnWriteArrayList来解决list并发问题
        copyOnWriteList();
    }

    /**
     * ArrayList并发问题，fail-fast机制，抛出java.util.ConcurrentModificationException
     */
    private static void listFailFast() {
        List<String> list = new ArrayList<>();

        //开启50个线程往ArrayList中添加数据
        for (int i = 1; i <= 50; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list + " | " + list.size());
            }, "线程" + String.valueOf(i)).start();
        }

    }

    private static void concurrencyListOfVector() {
        List<String> list = new Vector<>();

        //开启50个线程往ArrayList中添加数据
        for (int i = 1; i <= 50; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));

                /**
                 * Vector本身是在add和size方法上加了synchronized控制并发
                 * add和size方法聚合使用时，是有并发问题的，即当前线程add完，到执行size时，仍然是存在继续add的可能
                 * 从结果也是可以看出的，add结果正常，但是同时输出的size不一定与当时看到的结果一致
                 * 聚合方法使用时需要控制聚合操作的原子性
                 */
                System.out.println(list + " | " + list.size());
            }, "线程" + String.valueOf(i)).start();
        }

    }

    /**
     * 通过Collections.synchronizedList初始化可并发的list
     */
    private static void collectionInitSynList() {
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        // 开启50个线程往ArrayList中添加数据
        for (int i = 1; i <= 50; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));

                /**
                 * 通过包装内部类SynchronizedList，实现List接口，重写接口的方法，包装上synchronized关键字实现方法的并发
                 * 和Vector一样，add和size方法聚合使用时，是有并发问题的，即当前线程add完，到执行size时，仍然是存在继续add的可能
                 * 从结果也是可以看出的，add结果正常，但是同时输出的size不一定与当时看到的结果一致
                 * 聚合方法使用时需要控制聚合操作的原子性
                 */
                System.out.println(list + " | " + list.size());
            }, "线程" + String.valueOf(i)).start();
        }
    }

    /**
     * 通过CopyOnWriteArrayList来实现List的并发支持
     */
    private static void copyOnWriteList() {
        List<String> list = new CopyOnWriteArrayList<>();

        // 开启50个线程往ArrayList中添加数据
        for (int i = 1; i <= 50; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));

                /**
                 * 底层的存储依然是数组，transient不让其被序列化，volatile修饰来保证多线程下的其可见性和有序性
                 * private transient volatile Object[] array;
                 *
                 * add方法是通过重入锁保证元素添加时的并发安全
                 * 同时数据的新增是通过fail-safe机制，像我们的String一样，不在原来的对象上直接进行操作，而是复制一份对其进行修改
                 * 修改完之后重新赋值给原数组
                 *
                 * 同理remove/set也是如此设计，重入锁保证并发，fail-safe机制复制数据进行操作
                 *
                 * 同时其他读取数据的方法就是一般方法，无重入锁
                 * 如果读的时候有多个线程正在向CopyOnWriteArrayList添加数据，读还是会读到旧的数据，因为写的时候不会锁住旧的CopyOnWriteArrayList
                 *
                 * 因此，和之前的几种方式一致，add和size方法聚合使用时，是有并发问题的，即当前线程add完，到执行size时，仍然是存在继续add的可能
                 * 从结果也是可以看出的，add结果正常，但是同时输出的size不一定与当时看到的结果一致
                 * 聚合方法使用时需要控制聚合操作的原子性
                 *
                 *
                 * CopyOnWrite并发容器用于读多写少的并发场景。
                 * 比如白名单，黑名单，商品类目的访问和更新场景，假如我们有一个搜索网站，用户在这个网站的搜索框中，输入关键字搜索内容，
                 * 但是某些关键字不允许被搜索。这些不能被搜索的关键字会被放在一个黑名单当中，黑名单每天晚上更新一次。
                 * 当用户搜索时，会检查当前关键字在不在黑名单当中，如果在，则提示不能搜索。
                 *
                 * 内存占用问题
                 * 数据一致性问题
                 */
                System.out.println(list + " | " + list.size());
            }, "线程" + String.valueOf(i)).start();
        }
    }

}
