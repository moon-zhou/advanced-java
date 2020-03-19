package org.moonzhou.advancedprogramming.enumusing.designpattern;

/**
 * @Description 策略模式
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/19
 */
public class Strategy {
    public enum Calculator {

        /**
         * 加法
         */
        ADDITION {
            @Override
            public Double execute(Double x, Double y) {
                return x + y;
            }
        },

        /**
         * 减法
         */
        SUBTRACTION {
            @Override
            public Double execute(Double x, Double y) {
                return x - y;
            }
        },

        /**
         * 乘法
         */
        MULTIPLICATION {
            @Override
            public Double execute(Double x, Double y) {
                return x * y;
            }
        },

        /**
         * 除法
         */
        DIVISION {
            @Override
            public Double execute(Double x, Double y) {
                return x / y;
            }
        },

        ;

        public abstract Double execute(Double x, Double y);
    }

    public static void main(String[] args) {
        System.out.println(Calculator.ADDITION.execute(4.0, 2.0));
        // 打印 6.0
        System.out.println(Calculator.SUBTRACTION.execute(4.0, 2.0));
        // 打印 2.0
        System.out.println(Calculator.MULTIPLICATION.execute(4.0, 2.0));
        // 打印 8.0
        System.out.println(Calculator.DIVISION.execute(4.0, 2.0));
        // 打印 2.0
    }
}
