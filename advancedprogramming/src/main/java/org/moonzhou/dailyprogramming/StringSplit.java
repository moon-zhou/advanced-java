package org.moonzhou.dailyprogramming;

import java.lang.invoke.SwitchPoint;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author moon zhou
 * @description
 * @email ayimin1989@163.com
 * @date 2022/5/6 17:51
 **/
public class StringSplit {

    public static void main(String[] args) {

        List<String> depts = Arrays.asList("ABC", "BCD-1", "CDE-2-2", "DEF-3-3-3");
        depts.stream().forEach((dept) -> {
            System.out.println(dept.split("-")[0]);
        });

        String s1 = "A1234567";
        System.out.println("B" + s1.substring(3));

        System.out.println("----------");
        System.out.println(switchPaccount("b0051810"));
        System.out.println(switchPaccount("b0000010"));
    }


    private static String switchPaccount(String workNo) {
        Pattern pattern = Pattern.compile("^([A-Za-z])([0]+)([0-9]*)$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(workNo);
        if (matcher.find()) {
            String pname = matcher.group(3);
            String prefix = workNo.substring(0,1);
            if (prefix.equalsIgnoreCase("U")) {
                prefix = "P";
            } else if (prefix.equalsIgnoreCase("X")) {
                prefix = "T";
            }
            pname = prefix + pname;
            return pname;
        }

        return workNo;
    }
}
