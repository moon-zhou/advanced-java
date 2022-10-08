package org.moonzhou.dailyprogramming;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author moon zhou
 * @version 1.0
 * @description: json string to object by jackson
 * @date 2022/10/8 14:29
 */
public class TestJacksonFromJson {
    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\n" +
                "    \"info1\":\n" +
                "    [\n" +
                "        {\n" +
                "            \"name\": \"aaa111\",\n" +
                "            \"value\": \"aaa111\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"aaa222\",\n" +
                "            \"value\": \"aaa222\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"info2\":\n" +
                "    [\n" +
                "        {\n" +
                "            \"name\": \"bbb111\",\n" +
                "            \"value\": \"bbb111\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"bbb222\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"info3\":\n" +
                "    [\n" +
                "        {\n" +
                "            \"name\": \"ccc111\",\n" +
                "            \"value\": \"ccc111\",\n" +
                "            \"flag\": true\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\": \"ccc222\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"ccc333\",\n" +
                "            \"value\": \"ccc333\",\n" +
                "            \"flag\": true,\n" +
                "            \"subInfo\":\n" +
                "            [\n" +
                "                {\n" +
                "                    \"name\": \"sub111\",\n" +
                "                    \"value\": \"sub111\",\n" +
                "                    \"flag\": true\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"sub222\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Info info = objectMapper.readValue(json, Info.class);
        System.out.println(info);
    }

    @Getter
    @Setter
    static class Info {
        private List<Info1> info1;
        private List<Info2> info2;
        private List<Info3> info3;
    }

    @Getter
    @Setter
    static class Info1 {
        private String name;
        private String value;
    }

    @Getter
    @Setter
    static class Info2 {
        private String name;
        private String value;
    }

    @Getter
    @Setter
    static class Info3 {
        private String name;
        private String value;
        private Boolean flag;
        private List<SubInfo> subInfo;

        @Getter
        @Setter
        static class SubInfo {
            private String name;
            private String value;
            private Boolean flag;
        }
    }
}
