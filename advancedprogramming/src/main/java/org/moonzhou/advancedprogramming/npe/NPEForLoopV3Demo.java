package org.moonzhou.advancedprogramming.npe;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 使用Optional避免NPE
 *
 * @author moon-zhou
 * @date: 2020/3/8 20:39
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NPEForLoopV3Demo {
    public static void main(String[] args) {
        Optional<List<String>> list = getDatasFromDB();

        list.ifPresent(datas -> {
            for (String data : datas) {
                System.out.println(data);
            }
        });

        System.out.println("end...");
    }

    public static Optional<List<String>> getDatasFromDB() {
        boolean hasData = true;

        if (hasData) {
            String[] datas = {"moon1", "moon2", "moon3"};
            return Optional.of(Arrays.asList(datas));
        }

        return Optional.empty();
    }
}
