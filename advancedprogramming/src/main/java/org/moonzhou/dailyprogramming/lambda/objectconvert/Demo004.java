package org.moonzhou.dailyprogramming.lambda.objectconvert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Collectors.joining
 * @author moon zhou
 */
public class Demo004 {

    private static final String FORMAT = "( %s )";

    public static void main(String[] args) {
        List<String> currentUserList = Arrays.asList("a", "b", "c");

        String operator = currentUserList.stream().map(userId -> {
            // 重新修改userid的展示格式
            return change(userId);
        }).collect(Collectors.joining(","));

        System.out.println(operator);
    }

    private static String change(String param) {

        return String.format(FORMAT, param);
    }
}
