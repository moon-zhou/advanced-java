package org.moonzhou.advancedprogramming.generics.meta;

import lombok.extern.slf4j.Slf4j;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/8/1 21:41
 */
@Slf4j
public class ClassMeta {
    public static void main(String[] args) {
        log.info("Person.class.getSuperclass(): {}", Person.class.getSuperclass());
        log.info("Person.class.getGenericSuperclass(): {}", Person.class.getGenericSuperclass());

        log.info("Student.class.getSuperclass(): {}", Student.class.getSuperclass());
        log.info("Student.class.getGenericSuperclass(): {}", Student.class.getGenericSuperclass());

        log.info("ClassMeta.class.getSuperclass(): {}", ClassMeta.class.getSuperclass());
        log.info("ClassMeta.class.getGenericSuperclass(): {}", ClassMeta.class.getGenericSuperclass());

        log.info("Object.class.getGenericSuperclass(): {}", Object.class.getGenericSuperclass());
        log.info("Object.class.getSuperclass(): {}", Object.class.getSuperclass());

        log.info("void.class.getSuperclass(): {}", void.class.getSuperclass());
        log.info("void.class.getGenericSuperclass(): {}", void.class.getGenericSuperclass());

        log.info("int[].class.getSuperclass(): {}", int[].class.getSuperclass());
        log.info("int[].class.getGenericSuperclass(): {}", int[].class.getGenericSuperclass());
    }


}

class Person<T> {

}

class Student extends Person<ClassMeta> {

}
