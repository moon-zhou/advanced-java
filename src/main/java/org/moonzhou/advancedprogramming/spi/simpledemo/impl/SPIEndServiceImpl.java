package org.moonzhou.advancedprogramming.spi.simpledemo.impl;

import org.moonzhou.advancedprogramming.spi.simpledemo.SPIService;

/**
 * @Description spi实现之二
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/11
 */
public class SPIEndServiceImpl implements SPIService {
    @Override
    public void execute() {
        System.out.println("SPI test: end!");
    }
}
