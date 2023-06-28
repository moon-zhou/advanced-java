package org.moonzhou.dailyprogramming.lambda.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/6/13 16:38
 */
@Slf4j
public class Demo007StreamOperation {
    public static void main(String[] args) {
        jdkOperation();

        lambdaOperation();

        compareFunction();
    }

    private static void jdkOperation() {
        List<String> list = Arrays.asList("avocado", "apple", "banana", "orange");
        List<String> filteredList = new ArrayList<String>();
        for (String fruit : list) {
            if (fruit.startsWith("a")) {
                filteredList.add(fruit.toUpperCase());
            }
        }
        Collections.sort(filteredList);

        log.info("jdkOperation result: {}", filteredList);
    }

    private static void lambdaOperation() {
        List<String> list = Arrays.asList("avocado", "apple", "banana", "orange");
        List<String> filteredList = list.stream().filter(fruit -> fruit.startsWith("a")).map(String::toUpperCase).sorted().collect(Collectors.toList());

        log.info("lambdaOperation result: {}", filteredList);
    }

    /**
     * 经过测试可以得出，无论是max还是min，默认都是取的流中第一次出现的值，也就是遍历顺序中的第一个值。（即使是一个无序集合如set，在流中他都是有一定顺序的，只是这个顺序不是特定的，未知的一个顺序。）
     */
    private static void compareFunction() {
        List<User> userList = Arrays.asList(
                new User("小赵", 20),
                new User("小钱", 9),
                new User("小孙", 18),
                new User("小李", 13),
                new User("小周", 20),
                new User("小吴", 9)
        );
        log.info("测试有序list的情况---------");
        // 最大
        Optional<User> max = userList.stream()
                .max(Comparator.comparing(User::getAge));
        max.ifPresent(user -> log.info("年龄最大的数据为: {}", user));
        // 最小
        Optional<User> min = userList.stream()
                .min(Comparator.comparing(User::getAge));
        min.ifPresent(user -> log.info("年龄最小的数据为: {}", user));


        // 测试无序set的情况
        log.info("测试无序set的情况---------");
        Set<User> set = new HashSet<>(userList);
        // 最大
        max = set.stream()
                .max(Comparator.comparing(User::getAge));
        max.ifPresent(user -> log.info("年龄最大的数据为: {}", user));
        // 最小
        min = set.stream()
                .min(Comparator.comparing(User::getAge));
        min.ifPresent(user -> log.info("年龄最小的数据为: {}", user));
    }

    @Data
    @ToString
    @AllArgsConstructor
    static class User {
        /**
         * 姓名
         */
        private String name;
        /**
         * 年龄
         */
        private Integer age;
    }
}
