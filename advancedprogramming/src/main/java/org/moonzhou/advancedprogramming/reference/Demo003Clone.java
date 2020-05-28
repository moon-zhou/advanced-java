package org.moonzhou.advancedprogramming.reference;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/5/28 08:42
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo003Clone {
    public static void main(String[] args) {
        // 测试对象赋值，仅仅栈内存地址不一致，但是栈内存指向的实际堆内存中对象地址是一致的，其中一个对象的值变了，另一个值也变了
        testAssignment();

        testClone();
    }

    /**
     * 测试引用赋值
     * 仅仅栈内存地址不一致，但是栈内存指向的实际堆内存中对象地址是一致的，其中一个对象的值变了，另一个值也变了
     */
    private static void testAssignment() {
        User user = new User(18, "moon");
        User user1 = user;

        System.out.println("testAssignment before......");
        System.out.println(user);
        System.out.println(user1);
        System.out.println(user == user1);

        user.setAge(20);
        user.setName("hou");

        System.out.println("testAssignment after......");
        System.out.println(user);
        System.out.println(user1);
        System.out.println(user == user1);
    }

    private static void testClone() {
        UserClone userClone = new UserClone(18, "moon");

        try {
            UserClone userClone1 = (UserClone) userClone.clone();

            System.out.println("testClone before......");
            System.out.println(userClone);
            System.out.println(userClone1);
            System.out.println(userClone == userClone1);
            // 此处name指向的内存地址是一样的，是浅拷贝
            System.out.println(userClone.getName() == userClone1.getName() ? "浅拷贝" : "深拷贝");

            userClone.setAge(20);
            userClone.setName("hou");

            System.out.println("testClone after......");
            System.out.println(userClone);
            System.out.println(userClone1);
            System.out.println(userClone == userClone1);
            // 此处name指向的内存地址是一样的，表现为深拷贝
            System.out.println(userClone.getName() == userClone1.getName() ? "浅拷贝" : "深拷贝");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}

class User {
    private int age;

    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class UserClone implements Cloneable {
    private int age;

    private String name;

    public UserClone(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (UserClone) super.clone();
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}