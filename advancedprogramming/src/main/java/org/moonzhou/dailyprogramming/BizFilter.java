package org.moonzhou.dailyprogramming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/7/11 10:56
 */
public class BizFilter {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("M0035669", "A1"));
        userList.add(new User("M0003266", "A2"));
        userList.add(new User("M0027137", "A3"));
        userList.add(new User("M0028847", "A6"));
        userList.add(new User("M0082056", "B1"));
        userList.add(new User("MA005832", "B5"));
        userList.add(new User("MY001592", "B7"));
        userList.add(new User("MY001547", "B8"));
        userList.add(new User("MF100680", "A2"));
        userList.add(new User("MX016938", "B1"));
        userList.add(new User("MX016603", "B3"));
        userList.add(new User("MX005671", "C1"));
        userList.add(new User("MX016722", "BC"));

        userList.forEach(System.out::println);
        System.out.println();

        List<User> userOldList = userList.stream().filter(user -> !user.getUserId().startsWith("MX")
                && !user.getUserId().startsWith("UF")).collect(Collectors.toList());
        userOldList.forEach(System.out::println);
        System.out.println();

        List<User> userNewList = userList.stream().filter(user -> !(user.getUserId().startsWith("MX") && user.getSubgroup().startsWith("B"))
                && !user.getUserId().startsWith("MF")).collect(Collectors.toList());
        userNewList.forEach(System.out::println);
        System.out.println();
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    static class User {
        private String userId;
        private String subgroup;
    }
}
