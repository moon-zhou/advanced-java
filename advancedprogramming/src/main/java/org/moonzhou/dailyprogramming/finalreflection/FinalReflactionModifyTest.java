/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: FinalReflactionModifyTest.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/9/4 11:43
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.dailyprogramming.finalreflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述:final属性能否通过反射进行修改<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FinalReflactionModifyTest {

    public static void main(String[] args) throws Exception {

        new Thread(() -> {
            int count = 0;

            while (true) {

                if (count > 10) {
                    break;
                }

                System.out.println("loop value: " + ApplicationProperties.ATTR1);

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                count++;
            }

        }).start();

        System.out.println(ApplicationProperties.ATTR1);

        TimeUnit.SECONDS.sleep(1);

        Class applicationPropertiesClass = ApplicationProperties.class;
        Field attr1 = applicationPropertiesClass.getDeclaredField("ATTR1");
        attr1.setAccessible(true);

        /**
         * 去除final修饰符的影响，将字段设为可修改的
         * 否则会报异常<code>java.lang.IllegalAccessException: Can not set static final</code>
         */
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(attr1, attr1.getModifiers() & ~Modifier.FINAL);

        attr1.set("ATTR1", "123");

        // 此时直接使用时，发现值已经发生了变更
        System.out.println(ApplicationProperties.ATTR1);
    }
}
