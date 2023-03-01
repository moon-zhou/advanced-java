package org.moonzhou.advancedprogramming.guava;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/3/1 17:14
 */
public class Demo005ClassToInstanceMap {
    public static void main(String[] args) {
        guavaWay();
    }

    private static void jdkWay() {
        Map<Class, Object> map = new HashMap<>();
        User user = new User("Hydra", 18);
        Dept dept = new Dept("develop", 200);
        map.put(User.class, user);
        map.put(Dept.class, dept);
    }

    private static void guavaWay() {
        ClassToInstanceMap<Object> instanceMap = MutableClassToInstanceMap.create();
        User user = new User("Hydra", 18);
        Dept dept = new Dept("develop", 200);

        instanceMap.putInstance(User.class, user);
        instanceMap.putInstance(Dept.class, dept);
        System.out.println(instanceMap);

        // true: 取出对象时省去了复杂的强制类型转换(泛型)
        User user1 = instanceMap.getInstance(User.class);
        System.out.println(user == user1);
    }

    private static void guavaWay2() {
        // 指定泛型类型时，类型不符时，会在编译阶段进行检查报错
        ClassToInstanceMap<Map> instanceMap = MutableClassToInstanceMap.create();
        HashMap<String, Object> hashMap = new HashMap<>();
        TreeMap<String, Object> treeMap = new TreeMap<>();
        ArrayList<Object> list = new ArrayList<>();

        instanceMap.putInstance(HashMap.class, hashMap);
        instanceMap.putInstance(TreeMap.class, treeMap);

        // compile error
        // instanceMap.putInstance(ArrayList.class, list);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class User {
        private String name;
        private int age;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Dept {
        private String name;
        private int code;
    }

}
