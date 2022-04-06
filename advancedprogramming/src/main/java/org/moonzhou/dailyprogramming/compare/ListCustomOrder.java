package org.moonzhou.dailyprogramming.compare;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author moon zhou
 * @description TODO
 * @email ayimin1989@163.com
 * @date 2022/4/6 17:18
 **/
public class ListCustomOrder {
    public static void main(String[] args) {
        testDemo();

        testFormField();

        testFormField2();
    }

    private static void testDemo() {
        // 自定义一个顺序
        String[] regulation = {"语文", "数学", "外语"};
        final List<String> regulationOrder = Arrays.asList(regulation);
        String[] ordered = {"政治", "语文", "外语", "数学", "历史", "物理", "化学"};
        List<String> orderedList = Arrays.asList(ordered);
        Collections.sort(orderedList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int io1 = regulationOrder.indexOf(o1);
                int io2 = regulationOrder.indexOf(o2);
                return (io1 == -1 || io2 == -1) ? (io2 - io1) : (io1 - io2);
            }
        });
        System.out.println(orderedList);
    }

    private static void testFormField() {
        // 自定义一个顺序
        String[] regulation = {"中文姓名", "姓名拼音"};
        final List<String> regulationOrder = Arrays.asList(regulation);

        String[] ordered = {"工号", "身份证号码", "姓名拼音", "中文姓名", "电子邮箱", "手机号"};
        List<String> orderedList = Arrays.asList(ordered);

        /*Collections.sort(orderedList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int io1 = regulationOrder.indexOf(o1);
                int io2 = regulationOrder.indexOf(o2);
                return (io1 == -1 || io2 == -1) ? (io2 - io1) : (io1 - io2);
            }
        });*/
        Collections.sort(orderedList, (String o1, String o2) -> {
            int io1 = regulationOrder.indexOf(o1);
            int io2 = regulationOrder.indexOf(o2);
            return (io1 == -1 || io2 == -1) ? (io2 - io1) : (io1 - io2);
        });
        System.out.println(orderedList);
    }

    private static void testFormField2() {
        // 自定义一个顺序
        String[] regulation = {"中文姓名", "姓名拼音"};
        final List<String> regulationOrder = Arrays.asList(regulation);

        String[] ordered = {"工号", "身份证号码", "姓名拼音", "中文姓名", "电子邮箱", "手机号"};
        List<String> orderedList = Arrays.asList(ordered);

        orderedList.sort((o1, o2) -> {
            int io1 = regulationOrder.indexOf(o1);
            int io2 = regulationOrder.indexOf(o2);
            return (io1 == -1 || io2 == -1) ? (io2 - io1) : (io1 - io2);
        });

        System.out.println(orderedList);
    }
}


