package org.moonzhou.jdksource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * fail-fast demo <br>
 *
 * @author moon-zhou
 * @Date: 2019/12/25 22:12
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FastFailDemo {

    public static void main(String[] args) {

        testStringArrayList();

        //testUserArrayList();
    }

    private static void testStringArrayList() {
        /*
         * 使用工具类方法初始化，抛出java.lang.UnsupportedOperationException，该异常是AbstractList类里
         */
//        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API", "aaa");


        /*
         * 使用该初始化方法，则会抛出java.util.ConcurrentModificationException
         */
        List<String> features = new ArrayList<>();
        features.add("Lambdas");
        features.add("Default Method");
        features.add("Stream API");
        features.add("Date and Time API");
        features.add("aaa");


        for (String feature : features) {
            System.out.println(feature);
            if ("aaa".equals(feature)) {
                features.remove(feature);

                // 多加这个操作就不会有java.util.ConcurrentModificationException
                features.add("bbb");
            }
        }

        // java.lang.UnsupportedOperationException
        /*features.forEach(n -> {
            System.out.println(n);

            features.add("function");
        });*/

    }

    private static void testUserArrayList() {
        List<User> users = new ArrayList<>();
        users.add(new User(1));
        users.add(new User(2));
        users.add(new User(3));
        users.add(new User(4));
        users.add(new User(5));

        for (User user : users) {
            System.out.println(user.getId());

            // 该情况不会有java.util.ConcurrentModificationException
            if (user.getId() == 5) {
                System.out.println("remove");
                users.remove(user);
                users.add(new User(6));
            }

            // 有java.util.ConcurrentModificationException
            /*if (user.getId() == 2) {
                System.out.println("remove");
                users.remove(user);

                // 该句未生效
                users.add(new User(2));
            }*/
        }
    }

    static class User {
        private int id;

        public User(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
