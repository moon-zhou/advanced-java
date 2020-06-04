package org.moonzhou.practice.demo001producerconsumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

/**
 * 产品信息抽象<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/6/4 21:49
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Product implements Serializable {

    // 产品名称
    private String name;

    // 来自哪个生产者
    private String from;

    public Product(String name, String from) {
        this.name = name;
        this.from = from;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
