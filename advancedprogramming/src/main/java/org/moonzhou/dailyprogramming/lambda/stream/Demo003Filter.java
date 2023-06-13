package org.moonzhou.dailyprogramming.lambda.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author moon zhou
 * @version 1.0
 * @description: user by lambda filter
 * @date 2023/6/9 17:54
 */
@Slf4j
public class Demo003Filter {
    public static void main(String[] args) {

        List<User> userList = Arrays.asList(
                new User(1L, "moon1", 18, new BigDecimal(10000)),
                new User(1L, "moon1", 18, new BigDecimal(10000)),
                new User(2L, "moon2", 19, new BigDecimal(20000)),
                new User(3L, "moon3", 20, new BigDecimal(30000)));

        log.info("all user: {}", userList);

        List<User> distinctUserList = userList.stream()
                .filter(distinctByKey(User::getId))
                .collect(Collectors.toList());

        log.info("distinct userList: {}", distinctUserList);
    }


    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    @Data
    @AllArgsConstructor
    static class User {
        private Long id;
        private String name;
        private int age;
        private BigDecimal salary;
        //...
    }
}
