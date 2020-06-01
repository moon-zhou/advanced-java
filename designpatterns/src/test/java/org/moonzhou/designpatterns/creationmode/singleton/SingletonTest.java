package org.moonzhou.designpatterns.creationmode.singleton;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingletonTest {

    @Test
    public void testCasSingleton() {
        final CASSingleton instance1 = CASSingleton.getInstance();
        final CASSingleton instance2 = CASSingleton.getInstance();

        System.out.println(instance1);
        System.out.println(instance2);

        // 断言两个对象引用地址一致
        assertEquals(instance1, instance2);
    }

}