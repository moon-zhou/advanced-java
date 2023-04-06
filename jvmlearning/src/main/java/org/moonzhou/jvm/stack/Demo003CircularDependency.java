package org.moonzhou.jvm.stack;

/**
 * 循环依赖
 * -Xss256k: java.lang.StackOverflowError
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/4/6 13:59
 */
public class Demo003CircularDependency {
    public static void main(String[] args) {
        new A();
    }

    static class A {
        private B b;

        public A() {
            this.b = new B();
        }
    }

    static class B {
        private A a;

        public B() {
            this.a = new A();
        }
    }
}
