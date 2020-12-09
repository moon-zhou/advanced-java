/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: IdNoAgeTest.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/12/8 9:44
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.dailyprogramming;

import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;

/**
 * 功能描述:身份证号提取年龄计算示例<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class IdNoAgeTest {

    public static void main(String[] args) {

//        testLess();

        System.out.println("----------------");

        testMore();

        System.out.println("----------------");

        test();
    }

    private static void testLess() {
        String idNo15 = "352202590214873";
        String idNo18 = "352202195902148732";

        System.out.println(testAge(idNo15));
        System.out.println(testAge(idNo18));
    }

    private static void testMore() {
        String idNo15 = "420625921229030";
        String idNo18 = "420625199212290302";

        System.out.println(testAge(idNo15));
        System.out.println(testAge(idNo18));
    }

    private static void test() {
        System.out.println(testAge("320121199201251512"));
        System.out.println(testAge("34020219921210004X"));
        System.out.println(testAge("132201198905120619"));
    }

    private static String testAge(String idNo) {


        if (StringUtils.length(idNo) == 15) {
            int year = Integer.valueOf("19" + idNo.substring(6, 8));
            int month = Integer.valueOf(idNo.substring(8, 10));
            int day = Integer.valueOf(idNo.substring(10, 12));

            return String.valueOf(cal(year, month, day));
        } else if (idNo.length() == 18) {
            int year = Integer.valueOf(idNo.substring(6, 10));
            int month = Integer.valueOf(idNo.substring(10, 12));
            int day = Integer.valueOf(idNo.substring(12, 14));

            return String.valueOf(cal(year, month, day));
        }

        return "NA";
    }

    private static int cal(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayNow = cal.get(Calendar.DATE);

        // 已满周岁
        if (month < monthNow || (month == monthNow && day <= dayNow)) {
            return yearNow - year;
        } else {
            // 未满周岁
            return yearNow - year - 1;
        }
    }
}
