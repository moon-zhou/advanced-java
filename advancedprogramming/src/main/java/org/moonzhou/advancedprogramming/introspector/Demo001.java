package org.moonzhou.advancedprogramming.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;


/**
 * JavaBean规范：
 * 类是public的，然后有个无参的构造函数
 * 属性是private的，通过设置setXXX()和getXXX()来访问
 * 能支持事件，例如 addXXXXListener(XXXEvent e), 事件可以是 Click 事件，Keyboard 事件等等
 * 提供应该 反射机制，这样可以查看java bean的各种信息
 * 可以序列化，可以保存在硬盘上
 *
 * Introspector是一个专门处理JavaBean的工具类，用来获取JavaBean里描述符号。
 * 常用的JavaBean的描述符号相关类有BeanInfo、PropertyDescriptor，MethodDescriptor、BeanDescriptor、EventSetDescriptor和ParameterDescriptor。
 * <p>
 * 内省基于反射实现，主要用于操作JavaBean，基于JavaBean的规范进行Bean信息描述符的解析，依据于类的Setter和Getter方法，可以获取到类的描述符。
 * 如果一个类中的属性没有Setter和Getter方法，无法使用Introspector
 * <p>
 * 使用过程注意可能引起的内存泄漏问题
 * <p>
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

    static class Person {

        private Long id;
        private String name;
        private Integer age;
        private boolean deleted;

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

        public boolean isDeleted() {
            return deleted;
        }

        public void setDeleted(boolean deleted) {
            this.deleted = deleted;
        }
    }
}
