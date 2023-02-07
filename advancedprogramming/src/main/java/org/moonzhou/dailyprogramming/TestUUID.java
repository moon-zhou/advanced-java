package org.moonzhou.dailyprogramming;

import java.util.UUID;

/**
 * @author moon zhou
 * @version 1.0
 * @description: test uuid
 * @date 2023/1/10 16:40
 */
public class TestUUID {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
        System.out.println(UUID.randomUUID().toString().trim().replaceAll("-", ""));
    }
}
