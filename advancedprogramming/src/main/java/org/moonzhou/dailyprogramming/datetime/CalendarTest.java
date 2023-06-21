package org.moonzhou.dailyprogramming.datetime;

import java.util.Calendar;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/6/20 16:42
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());

        calendar.add(Calendar.DATE,-1);
        System.out.println(calendar.getTime());
    }
}
