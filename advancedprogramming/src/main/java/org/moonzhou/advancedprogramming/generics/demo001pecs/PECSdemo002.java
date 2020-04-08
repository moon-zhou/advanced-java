package org.moonzhou.advancedprogramming.generics.demo001pecs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author moon-zhou <ayimin1989@163.com>
 * @version V1.0.0
 * @description
 * @date 2020/4/6 11:11
 * @since 1.0
 */
public class PECSdemo002 {
    static class Parent1 {
    }

    static class Parent2 extends Parent1 {
    }

    static class Parent3 extends Parent2 {
    }

    static class T extends Parent3 {
    }

    static class Child1 extends T {
    }

    static class Child2 extends Child1 {
    }

    static class Child3 extends Child2 {
    }

    public static void main(String[] args) {
//        List<? extends T> extendsT = new ArrayList<Child1>();
//        List<? extends T> extendsT = new ArrayList<Child2>();
//        List<? extends T> extendsT = new ArrayList<Child3>();
        List<? extends T> extendsT = new ArrayList<>();

        // 实例化时，? super T规定了声明部分的最小边界T，还可以是其任何的父类
//        List<? super T > superT = new ArrayList<Parent1>();
//        List<? super T > superT = new ArrayList<Parent2>();
//        List<? super T > superT = new ArrayList<Parent3>();
        List<? super T > superT = new ArrayList<>();

        // 当向里面添加元素时，初始化的却是T的子类
        superT.add(new T());
        superT.add(new Child1());
        superT.add(new Child2());
        superT.add(new Child3());

        /**
         * extendsT中存放的其实是T的一种子类（现象），如果我们去添加元素，其实不知道到底应该添加T的哪个子类，
         * 这个时候，在进行强转的时候，肯定会出错。但是如果是从集合中将元素取出来，我们则可以知道取出来的元素肯定是T类型（全是它的子类）。
         */
//        extendsT.add(new T());//报错
//        extendsT.add(new Child1());//报错
//        extendsT.add(new Parent1());//报错
//        extendsT.add(new Parent2());//报错
//        extendsT.add(new Object());//报错

        /**
         *  super T。superT中，因为存的都是类型T的父类（容器），所以如果去添加T类或者T的子类（操作），肯定没什么问题。
         *  但是如果将元素取出来，则不知道到底是什么类型，所以superT可以添加元素但是没法取出来。
         *
         *  extendsT只出不进，属于生产者一类；superT只进不出，属于消费者。这也就有了我们上面所提到的“Producer Extends Consumer Super"，也就是PECS原则。
         */
    }
}
