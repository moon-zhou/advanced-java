package org.moonzhou.dailyprogramming.datetime;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;

/**
 * @author moon zhou
 * @version 1.0
 * @description: TODO
 * @date 2023/6/26 11:31
 */
public class LocalDateTimeTest003 {
    public static void main(String[] args) {
        LocalTime nowTime = LocalTime.now();
        System.out.println(nowTime);

        LocalTime earlyTime = nowTime.minusHours(3L);
        System.out.println(earlyTime);

        LocalDateTime nowDate = LocalDateTime.now();
        System.out.println(nowDate);

        LocalDateTime earlyDate = nowDate.minusMonths(6L);
        System.out.println(earlyDate);
        String earlyDateFormat = earlyDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(earlyDateFormat);

        Long l0 = 0L;
        Long l1 = 1L;
        System.out.println(l0.compareTo(l0));
        System.out.println(l0.compareTo(l1));
        System.out.println(l1.compareTo(l0));
        System.out.println(l1 > l0);

    }
}
