package org.moonzhou.advancedprogramming.basis.list;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/8/1 21:27
 */
@Slf4j
public class List002Extend {
    public static void main(String[] args) {

        List<Person> personList = new ArrayList<Person>(){};
        List<Student> studentList = new ArrayList<Student>(){};

        test(personList);
        log.info("-----------------------------");
        test(studentList);
    }

    private static void test(List list) {
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
            log.info("is Person: {}, {}", actualTypeArgument == Person.class, actualTypeArgument instanceof Person); // 只能 == 判断
            log.info("is Student: {}, {}", actualTypeArgument == Student.class, actualTypeArgument instanceof Student);
        }
    }

    static class Person {

    }

    static class Student extends Person {

    }
}
