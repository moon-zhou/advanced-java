package org.moonzhou.advancedprogramming.randomnumber;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2022/10/11 10:31
 */
public class Demo010SecureRandom {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom(); // Compliant for security-sensitive use cases

        System.out.println(random.nextInt());


        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        System.out.println(bytes);

        System.out.println(random.nextDouble());
        System.out.println(SecureRandom.getInstanceStrong().nextDouble());
        System.out.println(Math.random());


        System.out.println();
        System.out.println(String.valueOf((int) ((Math.random() * 9 + 1) * 100000)));
        System.out.println(String.valueOf(((random.nextInt() * 9 + 1) * 100000)));
        System.out.println(String.valueOf((int) ((random.nextDouble() * 9 + 1) * 100000)));


        System.out.println();
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random1 = new Random();
        System.out.println(random1.nextInt(str.length()));
        System.out.println(random.nextInt(str.length()));
    }
}
