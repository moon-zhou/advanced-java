/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: CountListMemory.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/12/9 15:09
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.jol;

import org.apache.commons.lang3.StringUtils;
import org.openjdk.jol.info.ClassLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述: 计算List<String>所占内存大小<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo003CountListMemory {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
//        TimeUnit.SECONDS.sleep(30);

//        Runtime r = Runtime.getRuntime();
//        long startRAM = r.freeMemory();
        List<String> listRAM = new ArrayList<>();
        int loopTimes = 450000;
        String string = null;
        int index = 1;
        for (int i = 0; i < loopTimes; i++) {
            string = StringUtils.leftPad(String.valueOf(index), 19, '0');
            listRAM.add(string);
            index++;
        }

        /*List<String> listRAM1 = new ArrayList<>();
        index = 1;
        for (int i = 0; i < loopTimes; i++) {
            string = StringUtils.leftPad(String.valueOf(index), 19, '0');
            listRAM1.add(string);
            index++;
        }*/
        /*long endRAM = r.freeMemory();
        Field f = ArrayList.class.getDeclaredField("elementData");
        f.setAccessible(true);
        Object[] o = (Object[]) f.get(listRAM);

        // 方案1 使用Runtime内存管理类
        String result = "测试RAM结束，测试占用内存空间约为 : " + (startRAM - endRAM);
        System.out.println(result);

        // 方案2 反射的方式查询ArrayList的实际申请长度，然后按照每个字符串申请了2字节进行计算

        result = "测试RAM结束，测试占用内存空间约为 : " + ((long) o.length * (long) string.length() * 2);
        System.out.println(result);

        // 方案3 反射的方式查询ArrayList的实际申请长度，然后取字符串的字节数组长度计算

        result = "测试RAM结束，测试占用内存空间约为 : " + ((long) o.length * (long) string.getBytes().length);
        System.out.println(result);*/

        System.out.println("1.---------" + ClassLayout.parseInstance(listRAM).toPrintable());

        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object array = field.get(listRAM);
        System.out.println("2.---------" + ClassLayout.parseInstance(array).toPrintable());

        /*System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("3.---------" + ClassLayout.parseInstance(listRAM1).toPrintable());
        Field field1 = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object array1 = field.get(listRAM1);
        System.out.println("4.---------" + ClassLayout.parseInstance(array1).toPrintable());*/

//        TimeUnit.HOURS.sleep(1);
    }
}
