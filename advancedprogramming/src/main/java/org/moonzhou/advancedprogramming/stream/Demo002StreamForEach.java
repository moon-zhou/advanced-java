package org.moonzhou.advancedprogramming.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author moon zhou
 * @version 1.0
 * @description: list.stream().foreach()和list.foreach()的对比
 * @date 2023/6/6 09:18
 */
public class Demo002StreamForEach {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C", "D");

        enhanceFor(list);

        lambdaFor(list);

        reverseListFor(list);
    }

    private static void enhanceFor(List<String> list) {
        System.out.println("enhance for demo start: ");

        for (String s : list) {
            System.out.print(s + " ");
        }

        System.out.println("\n-------\n");

    }

    private static void lambdaFor(List<String> list) {
        System.out.println("lambda for start: ");

        Consumer<String> consumer = System.out::print;
        list.forEach(consumer);

        System.out.println();
        list.forEach(System.out::print);
        System.out.println();
        list.forEach(s -> {
            System.out.print(s + " ");
        });

        System.out.println();
        list.stream().forEach(System.out::print);
        System.out.println();
        list.parallelStream().forEach(System.out::print); // 并行无序

        System.out.println("\n-------\n");
    }

    /**
     * 测试forEach会调用iterator，实际已经底层还是增强for，没有差别，不会调用
     * @param list
     */
    private static void reverseListFor(List<String> list) {
        System.out.println("reverse list for start: ");

        List<String> myList = new ReverseList();
        myList.addAll(list);
        myList.forEach(System.out::print);

        System.out.println();
        myList.stream().forEach(System.out::print);

        System.out.println("\n-------\n");
    }

    static class ReverseList extends ArrayList<String> {
        @Override
        public Iterator<String> iterator() {
            int startIndex = this.size() - 1;
            List<String> list = this;

            Iterator<String> it = new Iterator<String>() {
                private int currentIndex;

                @Override
                public boolean hasNext() {
                    return currentIndex >= 0;
                }

                @Override
                public String next() {
                    String next = list.get(currentIndex);
                    currentIndex--;
                    return next;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
            return it;
        }
    }

}
