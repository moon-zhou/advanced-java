package org.moonzhou.advancedprogramming.introspector;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/6/15 09:49
 */
@Slf4j
public class Demo003IntrospectorTest {
    @SneakyThrows
    public static void main(String[] args) {
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
        PropertyDescriptor[] pd = beanInfo.getPropertyDescriptors();

        // 迭代每一个描述器
        for (PropertyDescriptor propertyDescriptor : pd) {
            log.info("属性名: {}", propertyDescriptor.getName());
            log.info("setter: {}", propertyDescriptor.getWriteMethod());
            log.info("getter: {}:", propertyDescriptor.getReadMethod());
        }
    }

    private static class User {
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
