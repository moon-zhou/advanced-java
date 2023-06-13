package org.moonzhou.dailyprogramming.lambda.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/6/13 09:27
 */
@Slf4j
public class Demo006Collector {
    public static void main(String[] args) {
        forGroupBy();

        lambdaGroupBy();
    }

    private static void forGroupBy() {
        List<String> list = Arrays.asList("apple", "banana", "orange");
        Map<Integer, List<String>> grouped = new HashMap<Integer, List<String>>();
        for (String fruit : list) {
            int length = fruit.length();
            if (!grouped.containsKey(length)) {
                grouped.put(length, new ArrayList<String>());
            }
            grouped.get(length).add(fruit);
        }

        log.info("forGroupBy result: {}", grouped);
    }

    private static void lambdaGroupBy() {
        List<String> list = Arrays.asList("apple", "banana", "orange");
        // Map<Integer, List<String>> grouped = list.stream().collect(Collectors.groupingBy(fruit -> fruit.length()));
        Map<Integer, List<String>> grouped = list.stream().collect(Collectors.groupingBy(String::length));

        log.info("lambdaGroupBy result: {}", grouped);
    }
}
