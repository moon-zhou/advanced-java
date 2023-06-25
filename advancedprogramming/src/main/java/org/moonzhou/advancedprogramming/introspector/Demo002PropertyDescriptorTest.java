package org.moonzhou.advancedprogramming.introspector;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/6/15 09:39
 */
@Slf4j
public class Demo002PropertyDescriptorTest {

    @SneakyThrows
    public static void main(String[] args) {
        User user = new User(1L, "moon", 19, false);

        // PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", user.getClass());
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", User.class);
        log.info("property type: {}", propertyDescriptor.getPropertyType());

        Method readMethod = propertyDescriptor.getReadMethod();
        String name = (String)readMethod.invoke(user);
        log.info("method read name: {}, invoke value: {}.", readMethod.getName(), name);

        Method writeMethod = propertyDescriptor.getWriteMethod();
        writeMethod.invoke(user, "zhou");
        log.info("method write name: {}, new resule: {}", writeMethod.getName(), user.getName());
    }

    private static class User {
        private Long id;
        private String name;
        private Integer age;
        private boolean deleted;

        public User() {
        }

        public User(Long id, String name, Integer age, boolean deleted) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.deleted = deleted;
        }

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
