package org.moonzhou.advancedprogramming.basis.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Map遍历方式<br>
 * https://juejin.im/post/5ea91e67e51d454dc87f1add
 * <p>
 * HashMap 遍历从大的方向来说，可分为以下 4 类：
 * <p>
 * 迭代器（Iterator）方式遍历；
 * For Each 方式遍历；
 * Lambda 表达式遍历（JDK 1.8+）;
 * Streams API 遍历（JDK 1.8+）。
 * <p>
 * 但每种类型下又有不同的实现方式，因此具体的遍历方式又可以分为以下 7 种：
 * <p>
 * 使用迭代器（Iterator）EntrySet 的方式进行遍历；
 * 使用迭代器（Iterator）KeySet 的方式进行遍历；
 * 使用 For Each EntrySet 的方式进行遍历；
 * 使用 For Each KeySet 的方式进行遍历；
 * 使用 Lambda 表达式的方式进行遍历；
 * 使用 Streams API 单线程的方式进行遍历；
 * 使用 Streams API 多线程的方式进行遍历。
 *
 * @author moon-zhou
 * @date: 2020/5/7 20:15
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HashMapTest {

    public static void main(String[] args) {
        // 创建并赋值 HashMap
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        testIteratorEntry(map);

        testIteratorKeySet(map);

        testForEachEntry(map);

        testForEachKeySet(map);

        testLambda(map);

        testStream(map);

        testParallelStream(map);
    }

    private static void testIteratorEntry(Map<Integer, String> map) {
        System.out.println("testIteratorEntry...");

        // 遍历
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    private static void testIteratorKeySet(Map<Integer, String> map) {
        System.out.println("testIteratorKeySet...");

        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }

    private static void testForEachEntry(Map<Integer, String> map) {
        System.out.println("testForEachEntry...");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    private static void testForEachKeySet(Map<Integer, String> map) {
        System.out.println("testForEachKeySet...");

        for (Integer key : map.keySet()) {
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }

    private static void testLambda(Map<Integer, String> map) {
        System.out.println("testLambda...");

        map.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });
    }

    private static void testStream(Map<Integer, String> map) {
        System.out.println("testStream...");

        map.entrySet().stream().forEach((entry) -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }

    private static void testParallelStream(Map<Integer, String> map) {
        System.out.println("testParallelStream...");

        map.entrySet().parallelStream().forEach((entry) -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }
}
