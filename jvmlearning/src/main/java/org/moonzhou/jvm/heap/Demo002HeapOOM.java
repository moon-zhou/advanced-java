package org.moonzhou.jvm.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * mock oom: means heap oom
 * VM options: -Xms2m -Xmx2m
 *
 * @author moon zhou
 */
public class Demo002HeapOOM {
    public static void main(String[] args) {
        memoryInfo();

        List<Demo002HeapOOM> list = new ArrayList<>();
        while (true) {
            list.add(new Demo002HeapOOM());
            memoryInfo();
        }
    }

    private static void memoryInfo() {
        System.out.println("------------- 内存信息 -------------");

        // 返回Java虚拟机中的堆内存总量(从操作系统申请已经分配的内存，单位字节)
        Double xmsMemory = Runtime.getRuntime().totalMemory() / Double.valueOf(1024) / 1024;

        // 返回Java虚拟机中使用的最大堆内存(从操作系统可以申请的最大内存，单位字节)
        Double xmxMemory = Runtime.getRuntime().maxMemory() / Double.valueOf(1024) / 1024;

        // 可用内存大小(操作系统分配的内存里还没用上内存大小)
        Double freeMemory = Runtime.getRuntime().freeMemory() / Double.valueOf(1024) / 1024;

        System.out.println("-Xms:" + xmsMemory + "MB");
        System.out.println("-Xmx:" + xmxMemory + "MB");
        System.out.println("freeMemory:" + freeMemory + "MB");
    }
}
