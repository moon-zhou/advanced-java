package org.moonzhou.dateutils;

import java.time.LocalDate;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/8/22 11:09
 */
public class Demo002 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        // LocalDate yesterday = LocalDate.parse("2023-08-21");
        LocalDate yesterday = LocalDate.parse("2023-08-19");

        System.out.println(now.toEpochDay() - yesterday.toEpochDay());
        System.out.println(now.compareTo(yesterday));
        System.out.println(yesterday.compareTo(now));
        System.out.println(now.compareTo(now));
        // System.out.println(now.compareTo(null)); // NPE
    }
}
