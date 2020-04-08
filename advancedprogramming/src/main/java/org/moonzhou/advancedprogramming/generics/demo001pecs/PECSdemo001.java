package org.moonzhou.advancedprogramming.generics.demo001pecs;

/**
 * Producer Extends Consumer Super
 *
 * https://juejin.im/post/5df1c274518825127a036a7f
 *
 * @author moon-zhou <ayimin1989@163.com>
 * @version V1.0.0
 * @description
 * @date 2020/4/5 22:03
 * @since 1.0
 */
public class PECSdemo001 {
    static class C {
    }

    static class B extends C {
    }

    static class A extends B {
    }

    static class Example<T>{
    }

    public static void main(String[] args) {
        // <? extends T> 声明的是T的子类或者T本身
        Example<? extends A> testExtendsAA = new Example<A>();
        //Example<? extends A> testExtendsAB = new Example<B>();//报错
        //Example<? extends A> testExtendsAC = new Example<C>();//报错
        Example<? extends B> testExtendsBA = new Example<A>();
        //Example<? extends B> testExtendsBC = new Example<C>();//报错
        Example<? extends C> testExtendsCA = new Example<A>();
        Example<? extends C> testExtendsCB = new Example<B>();

        // <? super T> 只要是T的父类或者T本身，都没有什么问题，甚至可以是Object。Example<? super C> testCO = new Example<Object>();
        Example<? super A> testSuperAA = new Example<A>();
        Example<? super A> testSuperAB = new Example<B>();
        Example<? super A> testSuperAC = new Example<C>();
        //Example<? super B> testSuperBA = new Example<A>();//报错
        Example<? super B> testSuperBC = new Example<C>();
        //Example<? super C> testSuperCA = new Example<A>();//报错
        //Example<? super C> testSuperCB = new Example<B>();//报错

        Example<? super C> testCO = new Example<Object>();
    }
}
