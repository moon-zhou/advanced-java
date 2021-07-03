/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: TestByte.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/7/3 17:01
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.dailyprogramming;

import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;

/**
 * 功能描述:<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TestByte {

    private static final byte LEFT_PARENTHESIS = '(';
    private static final byte RIGHT_PARENTHESIS = ')';

    public static void main(String[] args) {

        String hello = "----(hello world!)-----";
        byte[] helloBytes = hello.getBytes();
        byte[] helloBytesUtf8s = hello.getBytes(Charset.defaultCharset());

        System.out.println(hello);
        System.out.println(helloBytes);
        System.out.println(helloBytesUtf8s);

        System.out.println();
        System.out.println(hello.length());
        System.out.println(helloBytes.length);
        System.out.println(helloBytesUtf8s.length);

        int leftPos = findByteIndex(helloBytes, LEFT_PARENTHESIS, true);
        int rightPos = findByteIndex(helloBytes, RIGHT_PARENTHESIS, false);
        int paramLen = rightPos - leftPos - 1;
        System.out.println(leftPos + "\t" + rightPos + "\t" + paramLen);
        System.out.println(hello.substring(leftPos + 1, rightPos));


        System.out.println();
        int lIndex = hello.indexOf('(');
        int rIndex = hello.lastIndexOf(')');
        int length = rIndex - lIndex + 1;
        System.out.println(lIndex + "\t" + rIndex + "\t" + length);
        System.out.println(hello.substring(lIndex + 1, rightPos));

        System.out.println(hello.substring(lIndex + 1, lIndex + 1 + paramLen));

        System.out.println(hello.substring(0, hello.length()));

        /*System.out.println();
        for (byte helloByte : helloBytes) {
            System.out.println(helloByte);
        }

        System.out.println();
        for (byte helloBytesUtf8 : helloBytesUtf8s) {
            System.out.println(helloBytesUtf8);
        }*/

    }

    public static int findByteIndex(byte[] bytes, byte value, boolean isFromLeft) {
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            if (isFromLeft && bytes[i] == value) {
                return i;
            }
            if (!isFromLeft && bytes[length - i - 1] == value) {
                return length - i - 1;
            }
        }
        return -1;
    }
}
