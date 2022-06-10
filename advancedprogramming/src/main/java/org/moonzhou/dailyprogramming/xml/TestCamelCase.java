package org.moonzhou.dailyprogramming.xml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 驼峰命名和非驼峰命名测试
 * @author moon zhou
 */
public class TestCamelCase {

    public static void main(String[] args) {
        CamelCase moon1 = new CamelCase("111", "moon1");
        System.out.println(moon1);
        moon1.setId("aaa");
        moon1.setName("moon zhou");
        System.out.println(moon1);

        NonCamelCase moon2 = new NonCamelCase("222", "moon2");
        System.out.println(moon2);
        moon2.setId("bbb");
        moon2.setName("moon zhou");
        System.out.println(moon2);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    static class CamelCase {
        private String id;
        private String name;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    static class NonCamelCase {
        private String Id;
        private String Name;
    }
}
