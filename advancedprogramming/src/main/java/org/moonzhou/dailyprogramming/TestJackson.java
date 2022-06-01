package org.moonzhou.dailyprogramming;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author moon zhou
 */
public class TestJackson {

    public static void main(String[] args) {
        String json = "{ \"name\" : \"汉字\", \"age\" : 28, \"height\": 1.75, \"ok\": true}";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            System.out.println(jsonNode.textValue());
            System.out.println(jsonNode.toString());
            System.out.println(jsonNode.toPrettyString());

            ObjectNode objectNode = (ObjectNode) jsonNode;
            objectNode.put("addField", "add");

            System.out.println(objectNode.toString());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
