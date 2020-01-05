package org.moonzhou.designpatterns.creationmode.builder.fourrole;

/**
 * 指挥者的接口，用来按照顺序组装汽车
 *
 * @author moon-zhou
 * @date 2020-1-5
 */
public interface Director {

    Car CreateCar();
}