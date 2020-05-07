package org.moonzhou.advancedprogramming.basis.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Map遍历方式<br>
 * https://juejin.im/post/5ea91e67e51d454dc87f1add
 *
 *
 * @author moon-zhou
 * @date: 2020/5/7 20:15
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HashMapTest {

    public static void main(String[] args) {
        // 创建并赋值 HashMap
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        testIteratorEntry(map);
    }

    private static void testIteratorEntry(Map<Integer, String> map) {
        // 遍历
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

}
