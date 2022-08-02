package org.moonzhou.advancedprogramming.randomnumber;

import java.util.Random;

/**
 * random repeat
 *
 * Random's JavaDoc:
 * If two instances of {@code Random} are created with the same
 * seed, and the same sequence of method calls is made for each, they
 * will generate and return identical sequences of numbers. In order to
 * guarantee this property, particular algorithms are specified for the
 * class {@code Random}. Java implementations must use all the algorithms
 * shown here for the class {@code Random}, for the sake of absolute
 * portability of Java code. However, subclasses of class {@code Random}
 * are permitted to use other algorithms, so long as they adhere to the
 * general contracts for all the methods.
 *
 * 如果我可以推测出你的 seed 的话，或者你的 seed 泄露了，那么理论上我就可以推测出你随机数生成序列。
 *
 * @author moon zhou
 */
public class Demo005RandomRepeat {
    public static void main(String[] args) {

        randomString(-229985452);

        System.out.println("------------");
        randomString(-229985452);

    }

    private static void randomString(int i) {
        Random ran = new Random(i);
        System.out.println(ran.nextInt());
        System.out.println(ran.nextInt());
        System.out.println(ran.nextInt());
        System.out.println(ran.nextInt());
        System.out.println(ran.nextInt());

    }
}
