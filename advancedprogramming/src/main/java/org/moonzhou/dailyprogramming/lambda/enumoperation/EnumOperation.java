package org.moonzhou.dailyprogramming.lambda.enumoperation;

import lombok.extern.slf4j.Slf4j;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/8/1 11:48
 */
@Slf4j
public class EnumOperation {
    public static void main(String[] args) {
        log.info("plus: {}", Operation.PLUS.apply(1.0, 1.0));
    }

    enum Operation {
        // 定义枚举值并重写抽象方法
        PLUS {
            @Override
            public double apply(double x, double y) {
                return x + y;
            }
        },
        MINUS {
            @Override
            public double apply(double x, double y) {
                return x - y;
            }
        },
        MULTIPLY {
            @Override
            public double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE {
            @Override
            public double apply(double x, double y) {
                return x / y;
            }
        };

        // 抽象方法，需要在每个枚举值中实现
        public abstract double apply(double x, double y);
    }
}
