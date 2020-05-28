package org.moonzhou.advancedprogramming.gc;

import java.util.LinkedList;
import java.util.List;

/**
 * 强引用示例demo<br>
 * 运行时请设置JVM参数：
 * <code>-Xms20M -Xmx20M -Xmn10M -verbose:gc -XX:+PrintGCDetails</code>
 *
 * -Xms：jvm启动时分配的内存
 * -Xmx：jvm运行过程中分配的最大内存
 * -Xmn：
 * -Xss：jvm启动的每个线程分配的内存大小，默认JDK1.4中是256K，JDK1.5+中是1M
 *
 * <p>强引用的实例对象，GC的时候这个对象GC Root可达，它就不会被回收。如果JVM内存不够了，直接抛出OOM。</p>
 *
 * 参考：https://juejin.im/post/5ec3c4aae51d45788a6d4e33
 *
 * @author moon-zhou
 * @date 2020/5/27 08:33
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo003StrongReference {
    public static void main(String[] args) {

        List<Object> list = new LinkedList<>();
        for (int i = 0; i < 21; i++) {
            list.add(new byte[1024 * 1024]);
        }
    }
}
