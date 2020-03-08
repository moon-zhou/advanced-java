package org.moonzhou.advancedprogramming.npe;

import java.util.Collections;
import java.util.List;

/**
 * 方法设计上避免NPE
 *
 * @author moon-zhou
 * @date: 2020/3/8 20:02
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NPEForLoopV2Demo {

    public static void main(String[] args) {
        List<String> datas = getDatasFromDB();
        for (String data : datas) {
            System.out.println(data);
        }
    }

    public static List<String> getDatasFromDB() {
        /*
         * 模拟此时没有从数据库获取到数据
         * 也可以直接手动返回空列表：new ArrayList<>()
         * 这也是方法涉及原则之一：方法/接口返回数据不能为null，除非null本身作为状态进行处理。有时甚至null状态也可以被转换掉
         */
        return Collections.emptyList();
    }
}