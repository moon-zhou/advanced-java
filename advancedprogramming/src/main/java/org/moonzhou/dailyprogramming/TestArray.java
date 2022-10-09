package org.moonzhou.dailyprogramming;

import lombok.Getter;
import lombok.Setter;

/**
 * @author moon zhou
 * @version 1.0
 * @description: string array
 * @date 2022/10/8 17:33
 */
public class TestArray {
    public static void main(String[] args) {
        String[] strArray = {"000"};
        System.out.println(strArray.equals("000"));

        System.out.println("---------------------------------");

        Types types = new Types();
        String[] typesField = types.getTypes();
        print(typesField);

        typesField[0] = "000";
        print(typesField);
    }

    private static void print(String[] ss) {
        for (String s : ss) {
            System.out.println(s);
        }
        System.out.println();
    }

    @Getter
    @Setter
    static class Types {
        // type array is reference type
        private String[] types = {"111", "222", "333"};
    }
}
