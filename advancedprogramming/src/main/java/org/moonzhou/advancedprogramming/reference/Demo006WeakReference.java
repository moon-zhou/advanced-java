package org.moonzhou.advancedprogramming.reference;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/**
 * 虚引用示例demo<br>
 * 运行时请设置JVM参数：
 * <code>-verbose:gc -XX:+PrintGCDetails</code>
 *
 * 只要这个对象发生GC，就会被回收。
 * 示例里手动GC后，都已经为null。
 *
 * 弱引用也适合用来做缓存，不过由于它是只要发生GC就会被回收，所以存活的时间比软引用短得多，通常用于做一些非常临时的缓存。
 *
 * 参考：https://juejin.im/post/5ec3c4aae51d45788a6d4e33
 *
 * @author moon-zhou
 * @date 2020/5/27 19:06
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo006WeakReference {
    public static void main(String[] args) {
        List<WeakReference<byte[]>> list = new LinkedList<>();
        for (int i = 0; i < 15; i++) {
            WeakReference<byte[]> weakReference = new WeakReference<>(new byte[1024 * 1024]);
            list.add(weakReference);
            System.out.println("gc前:" + weakReference.get());
        }
        System.gc();
        for (WeakReference<byte[]> weakReference : list) {
            System.out.println("gc后:" + weakReference.get());
        }
    }

}
