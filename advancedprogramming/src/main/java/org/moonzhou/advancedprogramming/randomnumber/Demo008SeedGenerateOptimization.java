package org.moonzhou.advancedprogramming.randomnumber;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 * 查询单词种子
 *
 * @author moon zhou
 */
public class Demo008SeedGenerateOptimization {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        generate("stack");
        generate("over");
        generate("flow");
        generate("rulez");

        System.out.println("Took " + (System.currentTimeMillis() - time) + " ms");
        System.out.println("---------");

        time = System.currentTimeMillis();
        generate("stack");
        generate("over");
        generate("flow");
        generate("rulez");

        System.out.println("Took " + (System.currentTimeMillis() - time) + " ms");
    }

    private static void generate(String goal) {
        long[] seed = generateSeed(goal, Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.println(seed[0]);
        System.out.println(randomString(seed[0], (char) seed[1]));
    }

    private static void generateOptimization(String goal) {
        long[] seed = generateSeedOptimization(goal, Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.println(seed[0]);
        System.out.println(randomString(seed[0], (char) seed[1]));
    }

    public static long[] generateSeed(String goal, long start, long finish) {
        char[] input = goal.toCharArray();
        char[] pool = new char[input.length];
        label:
        for (long seed = start; seed < finish; seed++) {
            Random random = new Random(seed);

            for (int i = 0; i < input.length; i++)
                pool[i] = (char) random.nextInt(27);

            if (random.nextInt(27) == 0) {
                int base = input[0] - pool[0];
                for (int i = 1; i < input.length; i++) {
                    if (input[i] - pool[i] != base)
                        continue label;
                }
                return new long[]{seed, base};
            }

        }

        throw new NoSuchElementException("Sorry :/");
    }

    /**
     * TODO 有待JMH测试，单测了几次，性能没有之前的好
     * @param goal
     * @param start
     * @param finish
     * @return
     */
    public static long[] generateSeedOptimization(String goal, long start, long finish) {
        char[] input = goal.toCharArray();

        int[] dif = new int[input.length - 1];
        for (int i = 1; i < input.length; i++) {
            dif[i - 1] = input[i] - input[i - 1];
        }

        mainLoop:
        for (long seed = start; seed < finish; seed++) {
            Random random = new Random(seed);
            int lastChar = random.nextInt(27);
            int base = input[0] - lastChar;
            for (int d : dif) {
                int nextChar = random.nextInt(27);
                if (nextChar - lastChar != d) {
                    continue mainLoop;
                }
                lastChar = nextChar;
            }
            if (random.nextInt(27) == 0) {
                return new long[]{seed, base};
            }
        }

        throw new NoSuchElementException("Sorry :/");
    }

    public static String randomString(long i, char base) {
        System.out.println("Using base: '" + base + "'");
        Random ran = new Random(i);
        StringBuilder sb = new StringBuilder();
        for (int n = 0; ; n++) {
            int k = ran.nextInt(27);
            if (k == 0)
                break;

            sb.append((char) (base + k));
        }

        return sb.toString();
    }
}
