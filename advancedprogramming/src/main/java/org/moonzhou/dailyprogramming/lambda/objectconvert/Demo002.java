package org.moonzhou.dailyprogramming.lambda.objectconvert;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author moon zhou
 * @description
 * @email ayimin1989@163.com
 * @date 2022/5/17 21:15
 **/
public class Demo002 {

    public static void main(String[] args) {
        List<Staff> staff = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );


        // Before Java 8
        List<String> result = new ArrayList<>();
        for (Staff x : staff) {
            result.add(x.getName());
        }

        System.out.println(result); //[mkyong, jack, lawrence]

        //Java 8
        List<String> collect = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println(collect); //[mkyong, jack, lawrence]
    }

    @Data
    @AllArgsConstructor
    static class Staff {
        private String name;
        private int age;
        private BigDecimal salary;
        //...
    }

}
