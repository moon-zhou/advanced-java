/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: TestCharString.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/5/21 17:15
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.dailyprogramming;

/**
 * 功能描述:<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TestCharString {
    public static void main(String[] args) {
        //string 转 byte[]
        String str = "Hello";
        byte[] srtbyte = str.getBytes();
        for (byte b : srtbyte) {
            System.out.println(b);
        }

        // byte[] 转 string
        String res = new String(srtbyte);
        System.out.println(res);
    }
}
