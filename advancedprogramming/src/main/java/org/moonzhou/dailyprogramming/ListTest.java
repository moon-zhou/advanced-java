package org.moonzhou.dailyprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/6/28 20:24
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(Arrays.asList("aa", "bb", "cc", "dd"));
        List<String> list2 = new ArrayList<>(Arrays.asList("bb", "cc"));
        System.out.println(list1);
        list1.removeAll(list2);
        System.out.println(list1);

        List<String> list3 = new ArrayList<>(Arrays.asList("aa", "bb", "cc", "dd"));
        List<String> list4 = new ArrayList<>(Arrays.asList("cc", "dd", "ee"));
        System.out.println(list3);
        list3.removeAll(list4);
        System.out.println(list3);

        // List<String> list5 = new ArrayList<>(Arrays.asList("aa", "bb", "cc", "dd"));
        // System.out.println(list5);
        // list5.removeAll(null); // NPE
        // System.out.println(list5);
    }
}
