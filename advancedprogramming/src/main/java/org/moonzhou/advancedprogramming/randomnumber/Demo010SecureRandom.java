package org.moonzhou.advancedprogramming.randomnumber;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2022/10/11 10:31
 */
public class Demo010SecureRandom {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom(); // Compliant for security-sensitive use cases
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);

        System.out.println(bytes);

        System.out.println(random.nextDouble());
        System.out.println(SecureRandom.getInstanceStrong().nextDouble());
        System.out.println(Math.random());
    }
}
