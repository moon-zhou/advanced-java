package org.moonzhou.dailyprogramming.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2022/10/18 11:38
 */
public class LocalDateTimeTest002 {

    public static void main(String[] args) {
        System.out.println(getDate());

        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00")));

        LocalDate localDate = LocalDate.of(2018, 1, 13);
        LocalTime localTime = LocalTime.of(9, 43, 20);
        LocalDateTime localDateTime = LocalDateTime.of(2018, 1, 13, 9, 43, 20);
        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

    }

    private static  String getDate() {

        Calendar cale = Calendar.getInstance();

        int year = cale.get(Calendar.YEAR);
        int month = cale.get(Calendar.MONTH) + 1;

        String monthDisplay = null;
        if (month < 10) {
            monthDisplay = "0" + month;
        } else {
            monthDisplay = month + "";
        }

        int date = cale.get(Calendar.DATE);
        String dateDisplay = null;
        if (date < 10) {
            dateDisplay = "0" + date;
        } else {
            dateDisplay = date + "";
        }
        String nowDate = year + "-" + monthDisplay + "-" + dateDisplay + " " + "00:00:00";

        return nowDate;

    }
}
