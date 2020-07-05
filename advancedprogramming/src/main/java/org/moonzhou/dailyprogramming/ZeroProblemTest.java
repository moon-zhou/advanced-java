/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: ZeroProblemTest.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/7/5 17:01
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.dailyprogramming;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 功能描述:<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ZeroProblemTest {
    public static void main(String[] args) throws ParseException {
//        debugProcess();


        simplifyProblem();

    }

    private static void debugProcess() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

//        long current = System.currentTimeMillis();
        /*Date date = new Date(current);
        String dateString = sdf.format(date);
        long time = date.getTime();*/
        Date date = sdf.parse("2020-07-05 23:59:59:333");
        long time = date.getTime();


        Calendar calendar = Calendar.getInstance();
        long calendarInMills = calendar.getTimeInMillis();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        long end = calendar.getTimeInMillis();

//        System.out.println("dateString: " + dateString);
        System.out.println("time: " + time);
//        System.out.println("current: " + current);
        System.out.println("first calendar: " + calendarInMills);
        System.out.println("end: " + end);
        System.out.println(end - time);

        long remainSecond = (end - time) / 1000;
        System.out.println(remainSecond);

        for (int i = 0; i < 2000; i++) {
            Random random = new Random();
            int cacheTime = random.nextInt(180);
            int result = (int) remainSecond + cacheTime;

            if (result < 0) {
                System.out.println("less than 0");
            } else if (result == 0) {
                System.out.println("equal 0");
            }/* else {
                System.out.println("more than 0");
            }*/
        }
    }

    private static void simplifyProblem() throws ParseException {
        // 模拟临界值时间（签到时间）
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        Date date = sdf.parse("2020-07-05 23:59:59:333");
        long time = date.getTime();

        // 模拟到下一天的24点
        Calendar calendar = Calendar.getInstance();
        long calendarInMills = calendar.getTimeInMillis();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long end = calendar.getTimeInMillis();

        // 模拟计算缓存时间，通过放大循环次数，看随机到0的情况
        for (int i = 0; i < 2000; i++) {
            // 原意为当前时间到明天零点还有多少秒，此处存在的问题为，如果小于1秒，此处精度丢失，变为0
            long remainSecond = (end - time) / 1000;
            Random random = new Random();

            // 如果随机的3分钟，也就是180秒，如果变成0，那么整体的缓存时间就为0，
            int cacheTime = random.nextInt(180);
            int result = (int) remainSecond + cacheTime;

            if (result < 0) {
                System.out.println("less than 0");
            } else if (result == 0) {
                System.out.println("equal 0");
            }/* else {
                System.out.println("more than 0");
            }*/
        }
    }
}
