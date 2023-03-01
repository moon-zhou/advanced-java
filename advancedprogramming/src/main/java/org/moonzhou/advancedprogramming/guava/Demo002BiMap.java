package org.moonzhou.advancedprogramming.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/3/1 10:36
 */
public class Demo002BiMap {

    public static void main(String[] args) {
        jdkWay();

        guavaWay();

        inverse();

        cannotRepeat();
    }

    private static void jdkWay() {
        Map<String, String> map = new HashMap<>();
        map.put("Hydra", "Programmer");
        map.put("Tony", "IronMan");
        map.put("Thanos", "Titan");

        System.out.println(map.get("Tony"));
        System.out.println(jdkMapFindKeyByVal(map, "Titan"));
    }

    private static List<String> jdkMapFindKeyByVal(Map<String, String> map, String val) {
        List<String> keys = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key).equals(val)) keys.add(key);
        }
        return keys;
    }

    private static void guavaWay() {
        HashBiMap<String, String> biMap = HashBiMap.create();
        biMap.put("Hydra", "Programmer");
        biMap.put("Tony", "IronMan");
        biMap.put("Thanos", "Titan");
        // 使用key获取value
        System.out.println(biMap.get("Tony"));

        BiMap<String, String> inverse = biMap.inverse();
        // 使用value获取key
        System.out.println(inverse.get("Titan"));
    }

    private static void inverse() {
        HashBiMap<String, String> biMap = HashBiMap.create();
        biMap.put("Hydra","Programmer");
        biMap.put("Tony","IronMan");
        biMap.put("Thanos","Titan");
        System.out.println(biMap);

        // inverse方法反转了原来BiMap的键值映射，但是这个反转后的BiMap并不是一个新的对象，它实现了一种视图的关联，所以对反转后的BiMap执行的所有操作会作用于原先的BiMap上
        BiMap<String, String> inverse = biMap.inverse();

        inverse.put("IronMan","Stark");
        System.out.println(biMap);
    }

    private static void cannotRepeat() {
        try {
            // exception: java.lang.IllegalArgumentException: value already present: IronMan
            HashBiMap<String, String> biMap = HashBiMap.create();
            biMap.put("Tony","IronMan");
            biMap.put("Stark","IronMan");
        } catch (Exception e) {
            e.printStackTrace();
        }

        HashBiMap<String, String> biMap = HashBiMap.create();
        biMap.put("Tony","IronMan");
        biMap.forcePut("Stark","IronMan");
        System.out.println(biMap);
    }
}
