package org.moonzhou.advancedprogramming.randomnumber;

import java.util.Random;

/**
 * https://juejin.cn/post/7085941661770973214
 *
 * https://www.itranslater.com/qa/details/2096539929210782720
 *
 * 线性同余生成器
 * @author moon zhou
 */
public class Demo006RandomStringExtend {

    public static void main(String[] args) {
        int[] arrInt = {-2146926310, -1885533740, -274140519,
                -2145247212, -1845077092, -2143584283,
                -2147483454, -2138225126, -2147375969};

        for(int seed : arrInt){
            System.out.print(randomString(seed) + " ");
        }
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
}
