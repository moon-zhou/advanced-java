package org.moonzhou.advancedprogramming.generics.simpledemo;

import sun.rmi.runtime.Log;

/**
 * @Description 测试泛型类
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/1
 */
public class App {
    public static void main(String[] args) {

        testGenericClass();
    }

    private static void testGenericClass() {
        // 泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
        // 传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        Generic<Integer> genericInteger = new Generic<Integer>(123456);
        Integer integerKey = genericInteger.getKey();
        System.out.println("泛型测试, 申明泛型类型为Integer, key is " + integerKey);

        // 传入的实参类型需与泛型的类型参数类型相同，即为String.
        Generic<String> genericString = new Generic<String>("key-value");
        String stringKey = genericString.getKey();
        System.out.println("泛型测试, 申明泛型类型为String, key is " + stringKey);

        // 如果不申明泛型类型，获取值时就需要进行显示的转换
        Generic param = new Generic("noDominantType");
        String noDominantType = (String) param.getKey();
        System.out.println("泛型测试, 未申明泛型类型, 强制转换为String, key is " + noDominantType);
    }
}
