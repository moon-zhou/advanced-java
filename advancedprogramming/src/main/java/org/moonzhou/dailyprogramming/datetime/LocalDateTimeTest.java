package org.moonzhou.dailyprogramming.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author moon zhou
 * @description
 * @email ayimin1989@163.com
 * @date 2022/4/20 13:51
 **/
public class LocalDateTimeTest {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()));
    }
}
