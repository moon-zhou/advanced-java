package org.moonzhou.advancedprogramming.guava;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/3/1 16:40
 */
public class Demo004RangeMap {
    public static void main(String[] args) {
        jdkWay();

        guavaWay();
    }

    private static void jdkWay() {
        System.out.println();
        System.out.println(getRank(59));
        System.out.println(getRank(60));
        System.out.println(getRank(90));
        System.out.println(getRank(91));
    }

    private static String getRank(int score) {
        if (0 <= score && score < 60)
            return "fail";
        else if (60 <= score && score <= 90)
            return "satisfactory";
        else if (90 < score && score <= 100)
            return "excellent";
        return null;
    }

    private static void guavaWay() {
        System.out.println();
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closedOpen(0,60),"fail");
        rangeMap.put(Range.closed(60,90),"satisfactory");
        rangeMap.put(Range.openClosed(90,100),"excellent");

        System.out.println(rangeMap.get(59));
        System.out.println(rangeMap.get(60));
        System.out.println(rangeMap.get(90));
        System.out.println(rangeMap.get(91));

        rangeMap.remove(Range.closed(70,80));
        System.out.println(rangeMap.get(75));
    }
}
