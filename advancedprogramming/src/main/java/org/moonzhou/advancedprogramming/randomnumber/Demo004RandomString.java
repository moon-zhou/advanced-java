package org.moonzhou.advancedprogramming.randomnumber;

import java.util.Random;

/**
 * random to output 'hello world'
 *
 * @author moon zhou
 */
public class Demo004RandomString {

    public static void main(String[] args) {
        System.out.println(randomString(-229985452) + " " + randomString(-147909649));
        System.out.println(randomString(-9223372036105109481L));
        System.out.println(randomString(-2147482772));
    }

    public static String randomString(int i) {
        Random ran = new Random(i);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int k = ran.nextInt(27);
            if (k == 0)
                break;

            sb.append((char) ('`' + k));
        }
        return sb.toString();
    }

    public static String randomString(long i) {
        Random ran = new Random(i);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int k = ran.nextInt(27);
            if (k == 0)
                break;

            sb.append((char) ('`' + k));
        }
        return sb.toString();
    }
}
