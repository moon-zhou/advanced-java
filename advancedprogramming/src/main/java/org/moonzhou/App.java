package org.moonzhou;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Timestamp timestamp= Timestamp.valueOf(LocalDateTime.now());
        System.out.println(timestamp.getTime());

        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间: " + currentTime);
        System.out.println("当前时间: " + currentTime.toString());

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);

        System.out.println(LocalDate.now().toString());

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate1 = LocalDate.parse("2023-08-02", fmt1);
        LocalDate localDate2 = LocalDate.parse("20230802", fmt2);
        System.out.println(localDate1);
        System.out.println(localDate2);
    }
}
