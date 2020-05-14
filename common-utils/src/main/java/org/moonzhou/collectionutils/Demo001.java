package org.moonzhou.collectionutils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/5/14 19:02
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001 {
    public static void main(String[] args) {
        Map<String, String> map = Maps.newHashMap();
        if (MapUtils.isEmpty(map)) {
            System.out.println("map is empty");
        }

        List<String> list = Lists.newArrayList();
        if (CollectionUtils.isEmpty(list)) {
            System.out.println("list is empty");
        }

//        String[] array = new String[1];
        String[] array = null;
        if (ArrayUtils.isEmpty(array)) {
            System.out.println("array is empty");
        } else {
            System.out.println(array.length);
            System.out.println(array[0]);
        }


        List<String> listA = new ArrayList<>();
        listA.add("1");
        listA.add("2");
        listA.add("3");
        String[] arrays = new String[]{"a", "b", "c"};
        CollectionUtils.addAll(listA, arrays);
        System.out.println(listA);
    }
}
