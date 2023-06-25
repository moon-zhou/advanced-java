package org.moonzhou.advancedprogramming.introspector.deomo001lombokconflict;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @author moon zhou
 * @version 1.0
 * @description: lombok conflict with introspector：未复现（该方式尽量避免使用lombok）
 * @date 2023/6/15 16:01
 */
@Slf4j
public class LombokConflict {
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
}
