package org.moonzhou.dailyprogramming.lambda.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
}
