package org.moonzhou.dailyprogramming.lambda.snippet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.moonzhou.advancedprogramming.stream.Demo004ModifyObjValue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author moon zhou
 * @version 1.0
 * @description: 
 * @date 2023/6/12 13:27
 */
@Slf4j
public class ListClearTest {
    public static void main(String[] args) {

        List<User> userList = Arrays.asList(
                new User(1L, "moon1", 18, new BigDecimal(10000)),
                new User(2L, "moon2", 19, new BigDecimal(20000)),
                new User(3L, "moon3", 20, new BigDecimal(30000)));
        log.info("main user init: {}", userList);

        process(userList);
        log.info("main user after: {}", userList);
    }

    /**
     * userList在处理表过程不能使用clear方法，或者remove等方法，实现过滤等业务含义
     * 如果需要业务过滤参数，可以考虑过滤完之后，通过返回值的方式返回处理
     * @param userList
     */
    private static void process(List<User> userList) {
        log.info("init user: {}", userList);

        List<User> temp = new ArrayList<>();
        temp.addAll(userList);

        log.info("temp1: {}", temp);
        // log.info("user clear: {}", userList);

        List<User> userFilter = temp.stream().filter(user -> 1 == user.getId()).collect(Collectors.toList());
        // 主方法里该变量引用，子方法不能对元素进行删除操作（new出来的局部变量，对主方法变量没有任何影响）
        // userList.clear();
        userList = new ArrayList<>();
        userList.addAll(userFilter);

        log.info("temp2: {}", temp);
        log.info("user filter: {}", userFilter);
        log.info("user after: {}", userList);
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
