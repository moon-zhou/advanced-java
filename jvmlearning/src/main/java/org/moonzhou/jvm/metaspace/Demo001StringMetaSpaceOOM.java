package org.moonzhou.jvm.metaspace;

import java.util.ArrayList;
import java.util.List;

/**
 * Java 8未复现
 * Java 7之后，常量池已经不在持久代之中进行分配了，而是移到了堆中，即常量池和对象共享堆内存。
 * -XX:MetaspaceSize=2m -XX:MaxMetaspaceSize=2m
 * @author moon zhou
 * @version 1.0
 * @description: meta space oom
 * @date 2023/4/6 17:46
 */
public class Demo001StringMetaSpaceOOM {
    private static String str = "test";

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while (true) {
            String str2 = str + str;
            str = str2;
            list.add(str.intern()); // JDK7的时候使用String.intern()不当，会产生大量常量数据
        }
    }

}
