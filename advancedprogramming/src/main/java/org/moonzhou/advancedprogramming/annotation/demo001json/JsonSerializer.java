package org.moonzhou.advancedprogramming.annotation.demo001json;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 注解反射解析的地方<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/4/13 17:38
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class JsonSerializer {
    public static String serialize(Object object) throws IllegalAccessException {
        Class<?> objectClass = object.getClass();
        Map<String, String> jsonElements = new HashMap<>();

        // 遍历申明的成员变量
        for (Field field : objectClass.getDeclaredFields()) {
            // 反射对象的成员变量可访问性设置为 true，使得private属性也可访问，否则抛出java.lang.IllegalAccessException
            field.setAccessible(true);

            // 判断字段是否有JsonField注解
            if (field.isAnnotationPresent(JsonField.class)) {
                jsonElements.put(getSerializedKey(field), (String) field.get(object));
            }
        }

        return toJsonString(jsonElements);
    }

    private static String getSerializedKey(Field field) {
        String annotationValue = field.getAnnotation(JsonField.class).value();

        return annotationValue.isEmpty() ? field.getName() : annotationValue;
    }

    private static String toJsonString(Map<String, String> jsonMap) {

        String elementsString = jsonMap.entrySet().stream().map(entry -> {
            return "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"";
        }).collect(Collectors.joining(","));

        return "{" + elementsString + "}";
    }
}
