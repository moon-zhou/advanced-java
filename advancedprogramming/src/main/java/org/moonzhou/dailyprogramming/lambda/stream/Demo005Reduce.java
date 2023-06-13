package org.moonzhou.dailyprogramming.lambda.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/6/13 09:23
 */
@Slf4j
public class Demo005Reduce {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int sum1 = list.stream().reduce(0, Integer::sum);
        int sum2 = list.stream().reduce(0, (a, b) -> a + b);

        log.info("sum1: {}, sum2: {}", sum1, sum2);
    }
}
