package org.moonzhou.jdksource;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * fail-safe demo <br>
 *
 * @author moon-zhou
 * @Date: 2019/12/25 23:15
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FailSafeDemo {

    public static void main(String[] args) {
        //testCopyOnWriteArrayList();

        testConcurrentHashMap();
    }

    public static void testCopyOnWriteArrayList() {
        List<Integer> integers = new CopyOnWriteArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        Iterator<Integer> itr = integers.iterator();
        while (itr.hasNext()) {
            Integer a = itr.next();
            integers.remove(a);
        }
    }

    public static void testConcurrentHashMap() {
        System.out.println("test ConcurrentHashMap fast-fail");
        Map<Integer, String> testConcurrentHashMap = new ConcurrentHashMap<Integer, String>();
        testConcurrentHashMap.put(100, "100");
        testConcurrentHashMap.put(200, "200");
        testConcurrentHashMap.put(300, "300");
        testConcurrentHashMap.put(400, "400");
        testConcurrentHashMap.put(500, "500");
        System.out.println(testConcurrentHashMap.size());
        for (Map.Entry<Integer, String> entry : testConcurrentHashMap.entrySet())
        {
            int key = entry.getKey();
            System.out.println("key=" + key);
            if (key == 300)
            {
                testConcurrentHashMap.remove(key);
            }
        }
        System.out.println(testConcurrentHashMap.size());
        for (Map.Entry<Integer, String> entry : testConcurrentHashMap.entrySet())
        {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
    }
}
