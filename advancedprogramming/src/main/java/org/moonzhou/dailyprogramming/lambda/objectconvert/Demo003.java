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
 * @date 2022/5/17 21:29
 **/
public class Demo003 {

    public static void main(String[] args) {
        List<Staff> staff = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );

        List<StaffPublic> result = convertToStaffPublic(staff);
        System.out.println(result);

        List<StaffPublic> resultLambda = convertToStaffPublicLambda(staff);
        System.out.println(resultLambda);
    }

    private static List<StaffPublic> convertToStaffPublic(List<Staff> staff) {
        List<StaffPublic> result = new ArrayList<>();

        for (Staff temp : staff) {
            StaffPublic obj = new StaffPublic();
            obj.setName(temp.getName());
            obj.setAge(temp.getAge());
            if ("mkyong".equals(temp.getName())) {
                obj.setExtra("this field is for mkyong only!");
            }
            result.add(obj);
        }

        return result;
    }

    private static List<StaffPublic> convertToStaffPublicLambda(List<Staff> staff) {
        // convert inside the map() method directly.
        List<StaffPublic> result = staff.stream().map(temp -> {
            StaffPublic obj = new StaffPublic();
            obj.setName(temp.getName());
            obj.setAge(temp.getAge());
            if ("mkyong".equals(temp.getName())) {
                obj.setExtra("this field is for mkyong only!");
            }
            return obj;
        }).collect(Collectors.toList());

        return result;
    }

    @Data
    @AllArgsConstructor
    static class Staff {
        private String name;
        private int age;
        private BigDecimal salary;
        //...
    }

    @Data
    static class StaffPublic {
        private String name;
        private int age;
        private String extra;
        //...
    }
}
