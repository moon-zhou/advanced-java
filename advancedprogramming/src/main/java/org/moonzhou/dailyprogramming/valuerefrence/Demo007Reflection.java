package org.moonzhou.dailyprogramming.valuerefrence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author moon zhou
 * @description 反射使用示例
 * @email ayimin1989@163.com
 * @date 2022/5/11 21:39
 **/
public class Demo007Reflection {

    public static void main(String[] args) throws IllegalAccessException {
        User moon = new User(1L, "moon", 18, LocalDateTime.now());

        Field[] declaredFields = User.class.getDeclaredFields();
        Map<String, Object> result = new HashMap<String, Object>();

        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            result.put(declaredField.getName(), declaredField.get(moon));
        }

        System.out.println(result);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User {
        private Long id;
        private String name;
        private int age;
        private LocalDateTime birthday;
    }
}
