package org.moonzhou.dateutils;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/5/14 08:55
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001 {
    public static void main(String[] args) {
        initialMethod();

        utilsMethod();

        dateUtilComputeMethod();

        jdk8LocalDate();

        jdk8LocalDateCompute();
    }

    private static void initialMethod() {

        System.out.println();

        // 注意线程安全问题
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Date 转 字符串
        String dateString = simpleDateFormat.format(new Date());
        System.out.println(dateString);

        try {
            // 字符串 转 Date
            Date date = simpleDateFormat.parse("2020-05-07 22:00:00");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static void utilsMethod() {

        System.out.println();

        // Date 转化为字符串
        String dateString = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println(dateString);

        // 字符串 转 Date
        try {
            Date date = DateUtils.parseDate("2020-05-07 22:00:00", "yyyy-MM-dd HH:mm:ss");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static void dateUtilComputeMethod() {
        System.out.println();

        Date now = new Date();
        System.out.println("now: " + now);

        // Date 加 1 天
        Date addDays = DateUtils.addDays(now, 1);
        System.out.println("add 1 day: " + addDays);

        // Date 加 33 分钟
        Date addMinutes = DateUtils.addMinutes(now, 33);
        System.out.println("add 33 minutes: " + addMinutes);

        // Date 减去 233 秒
        Date addSeconds = DateUtils.addSeconds(now, -233);
        System.out.println("add -233 seconds: " + addSeconds);

        // 判断是否 Wie 同一天
        boolean sameDay = DateUtils.isSameDay(addDays, addMinutes);
        System.out.println("is same day: " + sameDay);

        // 过滤时分秒,若 now 为 2020-05-07 22:13:00 调用 truncate 方法以后
        // 返回时间为 2020-05-07 00:00:00
        Date truncate = DateUtils.truncate(now, Calendar.DATE);
        System.out.println("truncate" + truncate);

    }

    private static void jdk8LocalDate() {
        System.out.println();

        Date now = new Date();

        // Date-----> LocalDateTime 这里指定使用当前系统默认时区
        LocalDateTime localDateTime = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(localDateTime);

        // LocalDateTime------> Date 这里指定使用当前系统默认时区
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(date);

        // 按照 yyyy-MM-dd HH:mm:ss 转化时间
        LocalDateTime dateTime = LocalDateTime.parse("2020-05-07 22:34:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(dateTime);

        // 将 LocalDateTime 格式化字符串
        String format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(dateTime);
        System.out.println(format);
    }

    private static void jdk8LocalDateCompute() {
        System.out.println();

        LocalDateTime now = LocalDateTime.now();
        // 年
        int year = now.getYear();
        System.out.println("year: " + year);

        // 月
        int month = now.getMonthValue();
        System.out.println("month: " + month);

        // 日
        int day = now.getDayOfMonth();
        System.out.println("day: " + day);

        // 当前时间加一天
        LocalDateTime plusDays = now.plusDays(1L);
        System.out.println("plus 1 day: " + plusDays);

        // 当前时间减一个小时
        LocalDateTime minusHours = now.minusHours(1L);
        System.out.println("minus 1 hour: " + minusHours);

    }
}
