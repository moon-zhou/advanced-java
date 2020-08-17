package org.moonzhou.advancedprogramming.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;


/**
 * Introspector是一个专门处理JavaBean的工具类，用来获取JavaBean里描述符号。
 * 常用的JavaBean的描述符号相关类有BeanInfo、PropertyDescriptor，MethodDescriptor、BeanDescriptor、EventSetDescriptor和ParameterDescriptor。
 *
 * 内省基于反射实现，主要用于操作JavaBean，基于JavaBean的规范进行Bean信息描述符的解析，依据于类的Setter和Getter方法，可以获取到类的描述符。
 * 如果一个类中的属性没有Setter和Getter方法，无法使用Introspector
 *
 * 使用过程注意可能引起的内存泄漏问题
 *
 * 链接：https://juejin.im/post/6859523396007526413
 */
public class Demo001 {

    public static void main(String[] args) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            if (!"class".equals(propertyDescriptor.getName())) {
                System.out.println(propertyDescriptor.getName());
                System.out.println(propertyDescriptor.getWriteMethod().getName());
                System.out.println(propertyDescriptor.getReadMethod().getName());
                System.out.println("=======================");
            }
        }
    }

    public static class Person {

        private Long id;
        private String name;
        private Integer age;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
