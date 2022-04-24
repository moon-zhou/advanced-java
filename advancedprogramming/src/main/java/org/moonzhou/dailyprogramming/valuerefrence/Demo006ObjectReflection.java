package org.moonzhou.dailyprogramming.valuerefrence;

import lombok.AllArgsConstructor;

import java.lang.reflect.Field;

/**
 * @author moon zhou
 * @description 值类型传递：值类型传递：同理，通过子方法里面new，并不会改变主方法变量的值，修改具体的值，只能通过主方法对象的set进行操作，对于未提供set方法的，只能通过反射进行操作。
 * @email ayimin1989@163.com
 * @date 2022/4/24 10:39
 **/
public class Demo006ObjectReflection {
    private static final String BEFORE_ADDRESS_FORMAT = "before 实参地址: %s";
    private static final String CHANGE_ADDRESS_FORMAT = "change 形参地址: %s";
    private static final String AFTER_ADDRESS_FORMAT = "after 实参地址: %s";

    private static final String BEFORE_OUT_FORMAT = "befor内容:------------- user: ";
    private static final String CHANGE_OUT_FORMAT = "形参内容：change:------------- user: ";
    private static final String AFTER_OUT_FORMAT = "实参内容：after:------------- user: ";

    public static void main(String[] args) {
        User moon = new User("moon", 18);

        System.out.println(String.format(BEFORE_ADDRESS_FORMAT, moon.toString()));
        System.out.println(BEFORE_OUT_FORMAT + moon.content());

        change(moon);

        System.out.println(String.format(AFTER_ADDRESS_FORMAT, moon.toString()));
        System.out.println(AFTER_OUT_FORMAT + moon.content());
    }

    private static void change(User user) {
        // 通过set方法进行修改，有效
        try {
            Class<? extends User> userClass = user.getClass();
            Field name = userClass.getDeclaredField("name");
            name.setAccessible(true);
            name.set(user, "zhou");
            Field age = userClass.getDeclaredField("age");
            age.setAccessible(true);
            age.set(user, 19);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println(String.format(CHANGE_ADDRESS_FORMAT, user.toString()));
        System.out.println(CHANGE_OUT_FORMAT + user.content());

        // 通过重新创建对象修改，无效，返回的主方法里面参数的地址值未受到影响
        user = new User("hahaha", 999);
        System.out.println(String.format(CHANGE_ADDRESS_FORMAT, user.toString()));
        System.out.println(CHANGE_OUT_FORMAT + user.content());
        System.out.println();
    }


    @AllArgsConstructor
    static class User {
        private static final String USER_CONTENT_FORMAT = "name: %s, age: %d";

        private String name;
        private int age;

        public String content() {
            return String.format(USER_CONTENT_FORMAT, name, age);
        }
    }
}
