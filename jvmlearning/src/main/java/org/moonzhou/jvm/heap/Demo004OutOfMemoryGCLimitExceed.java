package org.moonzhou.jvm.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * -Xms2m -Xmx2m: java.lang.OutOfMemoryError: Java heap space
 *
 * -Xms128m -Xmx128m: java.lang.OutOfMemoryError: GC overhead limit exceeded
 */
public class Demo004OutOfMemoryGCLimitExceed {
 
    public static void addRandomDataToMap() {
        Map<Integer, String> dataMap = new HashMap<>();
        Random r = new Random();
        while (true) {
            dataMap.put(r.nextInt(), String.valueOf(r.nextInt()));
        }
    }
 
    public static void main(String[] args) {
        addRandomDataToMap();
    }
}