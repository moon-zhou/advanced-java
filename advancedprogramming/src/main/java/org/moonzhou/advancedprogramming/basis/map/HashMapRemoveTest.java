package org.moonzhou.advancedprogramming.basis.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 遍历过程删除操作<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/5/8 19:26
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HashMapRemoveTest {

    public static void main(String[] args) {
        // 创建并赋值 HashMap
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");


//        iteratorRemove(map);
//        System.out.println(map);

        /*try {
            forRemove(map);
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        /*try {
            lambdaRemoveError(map);
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*lambdaRemove(map);
        System.out.println(map);*/

        /*try {
            streamRemoveError(map);
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        streamRemove(map);
        System.out.println(map);
    }

    private static void iteratorRemove(Map<Integer, String> map) {
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            if (entry.getKey() == 1) {
                // 删除
                System.out.println("del:" + entry.getKey());
                iterator.remove();
            } else {
                System.out.println("show:" + entry.getKey());
            }
        }

    }

    /**
     * 并发问题，快速失败，fast-fail
     * @param map
     */
    private static void forRemove(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() == 1) {
                // 删除
                System.out.println("del:" + entry.getKey());
                map.remove(entry.getKey());
            } else {
                System.out.println("show:" + entry.getKey());
            }
        }

    }

    /**
     * 并发问题，快速失败，fast-fail
     * @param map
     */
    private static void lambdaRemoveError(Map<Integer, String> map) {
        map.forEach((key, value) -> {
            if (key == 1) {
                System.out.println("del:" + key);
                map.remove(key);
            } else {
                System.out.println("show:" + key);
            }
        });
    }

    /**
     * lambda遍历过程中的正确删除方式
     * @param map
     */
    private static void lambdaRemove(Map<Integer, String> map) {
        // 根据 map 中的 key 去判断删除
        map.keySet().removeIf(key -> key == 1);
        map.forEach((key, value) -> {
            System.out.println("show:" + key);
        });
    }

    /**
     * 并发问题，快速失败，fast-fail
     * @param map
     */
    private static void streamRemoveError(Map<Integer, String> map) {
        map.entrySet().stream().forEach((entry) -> {
            if (entry.getKey() == 1) {
                System.out.println("del:" + entry.getKey());
                map.remove(entry.getKey());
            } else {
                System.out.println("show:" + entry.getKey());
            }
        });
    }

    /**
     * Stream 遍历过程中的正确删除方式
     * @param map
     */
    private static void streamRemove(Map<Integer, String> map) {
        map.entrySet().stream().filter(m -> 1 != m.getKey()).forEach((entry) -> {
            if (entry.getKey() == 1) {
                System.out.println("del:" + entry.getKey());
            } else {
                System.out.println("show:" + entry.getKey());
            }
        });
    }
}
