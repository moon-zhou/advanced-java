package org.moonzhou.designpatterns.creationmode.builder.fourrole;

/**
 * 轮胎
 * @author moon-zhou
 * @date 2020-1-5
 */
public class Tyre {
    private String name;

    public Tyre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}