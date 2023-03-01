package org.moonzhou.advancedprogramming.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.*;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/3/1 16:13
 */
public class Demo003MultiMap {
    public static void main(String[] args) {
        jdkWay();

        guavaWay();

        guavaWay2();
    }

    private static void jdkWay() {
        System.out.println();
        Map<String, List<Integer>> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        map.put("day",list);

        System.out.println(map);
    }

    private static void guavaWay() {
        System.out.println();
        Multimap<String, Integer> multimap = ArrayListMultimap.create();
        multimap.put("day",1);
        multimap.put("day",2);
        multimap.put("day",8);
        multimap.put("month",3);

        System.out.println(multimap);
    }

    private static void guavaWay2() {
        System.out.println();
        ArrayListMultimap<String, Integer> multimap = ArrayListMultimap.create();
        multimap.put("day",1);
        multimap.put("day",2);
        multimap.put("day",8);
        multimap.put("month",3);
        System.out.println(multimap);

        List<Integer> day = multimap.get("day");
        List<Integer> month = multimap.get("month");

        // get方法返回的集合上的操作仍然会作用于原始的Multimap上
        day.remove(0);//这个0是下标
        month.add(12);
        System.out.println(multimap);

        // asMap，将Multimap转换为Map<K,Collection>的形式，Map上的操作会作用于原始的Multimap
        Map<String, Collection<Integer>> map = multimap.asMap();
        for (String key : map.keySet()) {
            System.out.println(key+" : "+map.get(key));
        }
        map.get("day").add(20);
        System.out.println(multimap);
    }
}
