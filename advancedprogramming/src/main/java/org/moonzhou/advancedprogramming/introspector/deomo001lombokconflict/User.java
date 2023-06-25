package org.moonzhou.advancedprogramming.introspector.deomo001lombokconflict;

import lombok.Getter;
import lombok.Setter;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/6/25 10:51
 */
@Getter
@Setter
public class User {

    private Long id;
    private String name;
    private Integer age;
    private boolean deleted;
}
