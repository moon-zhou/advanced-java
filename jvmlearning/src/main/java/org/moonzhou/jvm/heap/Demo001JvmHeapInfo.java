package org.moonzhou.jvm.heap;

/**
 *
 * -Xms10m -Xmx10m 配置一样的值
 * -Xmx512m（实时查询的totalMemory和maxMemory值不一样）
 *
 * freeMemory: 可用空间会越来越少，知道最后不足时OOM
 *
 * @author moon zhou
 * @version 1.0
 * @description: jvm heap info
 * @date 2023/4/4 10:22
 */
public class Demo001JvmHeapInfo {

    public static void main(String[] args) {
        memoryInfo();

        // 1MB
        byte[] b1 = new byte[1*1024*1024];
        memoryInfo();

        // 2MB
        byte[] b2 = new byte[2*1024*1024];
        memoryInfo();

        // 3MB
        byte[] b3 = new byte[3*1024*1024];
        memoryInfo();

        // 4MB
        byte[] b4 = new byte[4*1024*1024];
        memoryInfo();
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
