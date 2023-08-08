package org.moonzhou.advancedprogramming.basis.string;

/**
 * @author moon zhou
 * @version 1.0
 * @description: string format test
 * @date 2023/8/8 09:09
 */
public class Demo007StringFormat {

    public static void main(String[] args) {
        String str = "";
        str=String.format("hallo World,%s", "你好，世界");
        System.out.println(str);
        str=String.format("Hi,%s,%s,%s", "小张","小王","小赵");
        System.out.println(str);
        System.out.printf("字母a的大写是：%c %n", 'A');
        System.out.printf("3>7的结果是：%b %n", 3>7);
        System.out.printf("100的一半是：%d %n", 100/2);
        System.out.printf("100的16进制数是：%x %n", 100);
        System.out.printf("100的8进制数是：%o %n", 100);
        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50*0.85);
        System.out.printf("上面价格的16进制数是：%a %n", 50*0.85);
        System.out.printf("上面价格的指数表示：%e %n", 50*0.85);
        System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50*0.85);
        System.out.printf("上面的折扣是%d%% %n", 85);
        System.out.printf("字母A的散列码是：%h %n", 'A');

        System.out.println(String.format("test long, %s", 100L));
    }
}
