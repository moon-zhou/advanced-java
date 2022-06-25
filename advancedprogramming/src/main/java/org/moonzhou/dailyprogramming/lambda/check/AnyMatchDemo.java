package org.moonzhou.dailyprogramming.lambda.check;

import java.util.ArrayList;
import java.util.List;

/**
 * @author moonzhou
 */
public class AnyMatchDemo {
    public static void main(String[] args) {
        List<String> conditionList = new ArrayList<>();
        conditionList.add("/aaa/aaa01/aaa02");
        conditionList.add("/bbb/bbb01/bbb02");
        conditionList.add("/ccc/ccc01/ccc02");

        String test1 = "/bbb/bbb01/bbb02";
        String test2 = "/bbb/bbb01/bbb02/bbb03";
        String test3 = "/bbb/bbb01";

        boolean result1 = conditionList.stream().anyMatch(temp -> test1.startsWith(temp));
        boolean result2 = conditionList.stream().anyMatch(temp -> test2.startsWith(temp));
        boolean result3 = conditionList.stream().anyMatch(temp -> test3.startsWith(temp));

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
