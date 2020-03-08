package org.moonzhou.advancedprogramming.npe;

import java.util.List;

/**
 * NullPointerException demo
 * 使用接口/方法时，判空避免NPE
 *
 * @author moon-zhou
 * @date: 2020/3/8 18:00
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NPEForLoopV1Demo {
    public static void main(String[] args) {
        List<String> datas = getDatasFromDB();

        // for遍历，必须判断遍历数据是否为null，否则会NPE
        if (datas != null) {

            for (String data : datas) {
                System.out.println(data);
            }
        } else {
            System.out.println("data list is null.");
        }
    }

    public static List<String> getDatasFromDB() {
        // 模拟此时没有从数据库获取到数据
        return null;
    }
}
