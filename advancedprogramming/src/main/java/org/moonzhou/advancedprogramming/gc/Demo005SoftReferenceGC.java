package org.moonzhou.advancedprogramming.gc;

import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;

/**
 * 软引用示例demo<br>
 * 运行时请设置JVM参数：
 * <code>-Xms20M -Xmx20M -Xmn10M -verbose:gc -XX:+PrintGCDetails</code>
 *
 * 与Demo004SoftReference相比，此demo获取了相关值进行验证，会发现，打印出的日志，GC前都是有值的，而GC后，会有一些是null，代表它们已经被回收。
 * 但如果减少循环次数，GC后没有为null的。但通过-verbose:gc -XX:+PrintGCDetails参数能发现，JVM还是进行了几次GC的，只是由于内存还够用，所以没有回收。
 *
 * @author moon-zhou
 * @date 2020/5/27 18:17
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo005SoftReferenceGC {
    public static void main(String[] args) {
//        softReferenceMemeoryLess();

        softReferenceMemeoryEnough();
    }

    private static void softReferenceMemeoryLess() {
        List<SoftReference<byte[]>> list = new LinkedList<>();
        for (int i = 0; i < 21; i++) {
            SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024]);
            list.add(softReference);
            System.out.println("gc前:" + softReference.get());
        }
        System.gc();
        for (SoftReference<byte[]> softReference : list) {
            System.out.println("gc后:" + softReference.get());
        }
    }

    public static void softReferenceMemeoryEnough() {
        List<SoftReference<byte[]>> list = new LinkedList<>();
        for (int i = 0; i < 15; i++) {
            SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024]);
            list.add(softReference);
            System.out.println("gc前:" + softReference.get());
        }
        System.gc();
        for (SoftReference<byte[]> softReference : list) {
            System.out.println("gc后:" + softReference.get());
        }
    }


}
