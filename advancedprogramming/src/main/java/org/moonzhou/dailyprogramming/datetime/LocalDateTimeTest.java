package org.moonzhou.dailyprogramming.datetime;

import java.time.LocalDate;
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

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(dateFormatter.format(LocalDateTime.now()));
        DateTimeFormatter dateFormatter2 = DateTimeFormatter.ofPattern("MM/yyyy");
        System.out.println(dateFormatter2.format(LocalDateTime.now()));

        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/yyyy")));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00")));

        System.out.println(LocalDate.now().getYear());
    }
}
