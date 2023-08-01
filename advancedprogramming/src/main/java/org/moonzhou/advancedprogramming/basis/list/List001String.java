package org.moonzhou.advancedprogramming.basis.list;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author moon zhou
 * @version 1.0
 * @description: list string 泛型判断
 * @date 2023/8/1 20:49
 */
@Slf4j
public class List001String {
    public static void main(String[] args) {
        // 大括号不能少
        List<String> list = new ArrayList<String>(){};
        // List<String> list = new ArrayList<String>();
        // list.add("1");

        Class<? extends List> listClazz = list.getClass();
        Type clazz = listClazz.getGenericSuperclass();
        log.info("type: {}", clazz.getTypeName());
        log.info("is List: {}, {}", clazz instanceof List, clazz == List.class);
        log.info("is ArrayList: {}, {}", clazz instanceof ArrayList, clazz == ArrayList.class);

        // 如果是泛型参数的类型
        if(clazz instanceof ParameterizedType){
            ParameterizedType pt = (ParameterizedType)clazz;
            Type actualTypeArgument = pt.getActualTypeArguments()[0];

            log.info("generic type: {}, {}", actualTypeArgument.toString(), actualTypeArgument.getTypeName());
            log.info("is String: {}", actualTypeArgument == String.class);
        }
    }
}
