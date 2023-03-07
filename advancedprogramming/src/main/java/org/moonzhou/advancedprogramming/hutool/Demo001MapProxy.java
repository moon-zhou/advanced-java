package org.moonzhou.advancedprogramming.hutool;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapProxy;
import cn.hutool.core.map.MapUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/3/7 10:13
 */
@Slf4j
public class Demo001MapProxy {

    public static void main(String[] args) {
        oldWay();

        hutoolWay();

        hutoolMapUtilWay();
    }

    private static void oldWay() {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("username", "alvin");
        userMap.put("age", 20);

        // 使用map的时候, 需要进行强转，一旦类型错误，会报错
        // String age = (String)userMap.get("age");
        int age = (int) userMap.get("age");
        log.info("old way age: {}", age);
    }

    private static void hutoolWay() {
        Map<String, Object> userMap = MapUtil.newHashMap(16);
        userMap.put("username", "alvin");
        userMap.put("age", 20);

        MapProxy mapProxy = MapProxy.create(userMap);
        Integer age = mapProxy.getInt("age", 18);
        log.info("hutool way: {}", age);

        // 通过代理的方式
        MapUser mapUser = mapProxy.toProxyBean(MapUser.class);
        log.info("hutool proxy way: {}", mapUser.getAge());
        mapUser.setAge(30);
        log.info("hutool proxy way: {}", mapUser.getAge());

    }

    private static void hutoolMapUtilWay() {
        Map<String, Object> userMap = MapUtil.newHashMap();
        userMap.put("name", "moon");
        userMap.put("age", 18);
        log.info("user map: {}", userMap);

        String name = MapUtil.getStr(userMap, "name");
        Integer age = MapUtil.getInt(userMap, "age");
        log.info("util get: {}, {}", name, age);

        User user = BeanUtil.toBean(userMap, User.class);
        log.info("user: {}", user);
    }


    static interface MapUser {
        String getUsername();

        Integer getAge();

        MapUser setAge(Integer age);
    }

    @Data
    static class User {
        private String name;
        private int age;
    }
}
