package org.moonzhou.dailyprogramming.compare;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

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

        testFormField3();

        testSortLast();
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

    private static void testFormField3() {
        // 自定义一个顺序
        String[] regulation = {"姓的拼音", "名的拼音"};
        final List<String> regulationOrder = Arrays.asList(regulation);

        String[] ordered = {"工号", "身份证号码", "中文姓名", "姓的拼音", "名的拼音", "电子邮箱", "手机号"};
        List<String> orderedList = Arrays.asList(ordered);

        String s = orderedList.stream().filter(o -> StringUtils.equals(o, "姓的拼音") || StringUtils.equals(o, "名的拼音")).findAny().orElse(null);
        List<String> collect = orderedList.stream().filter(o -> StringUtils.equals(o, "姓的拼音") || StringUtils.equals(o, "名的拼音")).collect(Collectors.toList());

        System.out.println(s);
        System.out.println(collect);
    }

    private static void testSortLast() {
        List<User> userList = new ArrayList<>();
        User user1 = new User(1, "工号");
        User user2 = new User(2, "身份证号码");
        User user3 = new User(3, "中文姓名");
        User user4 = new User(4, "姓的拼音");
        User user5 = new User(5, "名的拼音");
        User user6 = new User(6, "电子邮箱");
        User user7 = new User(7, "手机号");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userList.add(user7);

        System.out.println("sort before---------");
        System.out.println(userList);

        String[] regulation = {"姓的拼音", "名的拼音"};
        final List<String> regulationOrder = Arrays.asList(regulation);

        List<User> lastColumn = userList.stream().filter(o -> regulationOrder.contains(o.getName())).collect(Collectors.toList());
        System.out.println(lastColumn);

        List<User> otherColumn = userList.stream().filter(o -> !regulationOrder.contains(o.getName())).collect(Collectors.toList());
        System.out.println(otherColumn);

        userList.clear();
        System.out.println("clear user list");
        System.out.println(userList);
        userList.addAll(otherColumn);
        userList.addAll(lastColumn);

        System.out.println("sort after---------");
        System.out.println(userList);
    }

    @Data
    @AllArgsConstructor
    static
    class User {
        int id;
        String name;
    }
}


