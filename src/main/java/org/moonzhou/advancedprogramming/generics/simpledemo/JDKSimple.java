package org.moonzhou.advancedprogramming.generics.simpledemo;

import java.util.ArrayList;

import java.util.List;

/**
 * @Description JDK里的泛型使用
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/1
 */
public class JDKSimple {

    public static void main(String[] args) {
        testArrayList();
    }

    /**
     * 测试List里的泛型使用，同理Map/Set用法一致
     */
    private static void testArrayList() {
        List<String> stringList = new ArrayList<String>();
        stringList.add("aaa");
        stringList.add("bbb");

        stringList.forEach(System.out::println);

        // 初始化时限定了列表变量类型为String
        String firstStr = stringList.get(0);
        System.out.println("第一个String：" + firstStr);
        System.out.println();

        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(111);
        integerList.add(222);

        integerList.forEach(System.out::println);

        Integer firstInt = integerList.get(0);
        System.out.println("第一个int：" + firstInt);
    }
}
