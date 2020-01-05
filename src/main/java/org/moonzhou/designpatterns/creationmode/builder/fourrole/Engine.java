package org.moonzhou.designpatterns.creationmode.builder.fourrole;

/**
 * 引擎
 * @author moon-zhou
 * @date 2020-1-5
 */
public class Engine {

    private String name;

    public Engine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
