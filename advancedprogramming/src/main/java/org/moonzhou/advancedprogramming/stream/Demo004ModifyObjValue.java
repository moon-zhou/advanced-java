package org.moonzhou.advancedprogramming.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/6/12 11:32
 */
@Slf4j
public class Demo004ModifyObjValue {


    public static void main(String[] args) {
        List<User> userList = Arrays.asList(
                new User(1L, "moon1", 18, new BigDecimal(10000)),
                new User(2L, "moon2", 19, new BigDecimal(20000)),
                new User(3L, "moon3", 20, new BigDecimal(30000)));

        log.info("user1: {}", userList);

        userList.forEach(user -> {
            user.setSalary(user.getSalary().add(new BigDecimal("1000")));
        });

        log.info("user2: {}", userList);
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
