package org.moonzhou.advancedprogramming.randomnumber;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 * 查询单词种子
 * <p>
 * -2147482998
 * -2147455571
 * -2126765086
 * -1255888825
 * -2147058567
 * -2146764626
 * -2147058567
 *
 * @author moon zhou
 */
public class Demo007SeedGenerate {

    public static void main(String[] args) {
        System.out.println(generateSeed("i", Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(generateSeed("am", Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(generateSeed("fine", Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(generateSeed("thank", Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(generateSeed("you", Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(generateSeed("and", Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(generateSeed("you", Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    public static long generateSeed(String goal, long start, long finish) {
        char[] input = goal.toCharArray();
        char[] pool = new char[input.length];
        label:
        for (long seed = start; seed < finish; seed++) {
            Random random = new Random(seed);

            for (int i = 0; i < input.length; i++)
                pool[i] = (char) (random.nextInt(27) + '`');

            if (random.nextInt(27) == 0) {
                for (int i = 0; i < input.length; i++) {
                    if (input[i] != pool[i])
                        continue label;
                }
                return seed;
            }
        }
        throw new NoSuchElementException("Sorry   :/");
    }
}
