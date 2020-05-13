package org.moonzhou.stringutils;

import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/5/13 19:32
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo002StringAppend {
    public static void main(String[] args) {

        initialStringMethod();

        utils();

        guvaListJoin();
    }

    /**
     * 通过原始方式拼接字符串
     */
    private static void initialStringMethod() {
        String[] array = new String[]{"test", "1234", "5678"};
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : array) {
            stringBuilder.append(s).append(";");
        }
        // 防止最终拼接字符串为空
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        System.out.println(stringBuilder.toString());

    }

    private static void utils() {
        System.out.println(StringUtils.join(new String[]{"test", "1234", "5678"}, ","));
    }

    private static void guvaListJoin() {
        String[] array = new String[]{"test", "1234", "5678"};
        List<String> list = new ArrayList<>();
        list.add("test");
        list.add("1234");
        list.add("5678");

        // 逗号分隔符，跳过 null
        Joiner joiner = Joiner.on(",").skipNulls();
        String arrayJoinResult = joiner.join(array);
        String listJoinResult = joiner.join(list);

        System.out.println("guava join array: " + arrayJoinResult);
        System.out.println("guava join list: " + listJoinResult);
    }
}
