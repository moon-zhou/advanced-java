package org.moonzhou.dailyprogramming.lambda.snippet;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author moon zhou
 * @version 1.0
 * @description: compare
 * @date 2023/6/6 10:16
 */
public class LambdaComparator {

    public static void main(String[] args) {
        collectionSort();
        lambdaSort();
    }

    private static void collectionSort() {
        List<String> list = Arrays.asList("apple", "orange", "banana");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        System.out.println(list);
    }

    private static void lambdaSort() {
        List<String> list = Arrays.asList("apple", "orange", "banana");

        // Collections.sort((s1, s2) -> s1.compareTo(s2));
        // list.sort((s1, s2) -> s1.compareTo(s2));
        // list.sort(String::compareTo);
        list.sort(Comparator.naturalOrder());

        System.out.println(list);
    }

}