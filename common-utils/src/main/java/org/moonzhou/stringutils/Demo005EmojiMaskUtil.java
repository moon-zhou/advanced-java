/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: EmojiMaskUtil.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/10/12 10:19
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.stringutils;

/**
 * 功能描述: emoji隐位<br>
 * <p>
 * 来源：https://juejin.im/post/6881336349169811464
 * 可优化：当前代码只能判断emoji为两个unicode格式的，如果有多个Unicode表示一个emoji，e.g.👨‍🏫或者👪，就需要再额外的处理的。
 *      抽象校验接口，针对不同的Unicode格式，单独写校验方法，上层判断出emoji都进行一遍处理，一旦命中处理过之后，后续的规则则不处理。
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo005EmojiMaskUtil {
    public static void main(String[] args) {
        // 用户昵称为：🐳🐳🐠，正常结果应该为：🐳***🐠
        String context = "\uD83D\uDC33\uD83D\uDC33\uD83D\uDC20";
        int realNameLength = realStringLength(context);
        String namePrefix = subString(context, 1, 0);
        String nameSuffix = subString(context, realNameLength - 1, 1);
        context = String.format("%s%s%s", namePrefix, "***", nameSuffix);
        System.out.println(context);
    }

    /**
     * 包含emoji表情的subString方法
     *
     * @param str  原有的str
     * @param len  str长度
     * @param type type = 0 代表prefix，其他代表suffix
     */
    private static String subString(String str, int len, int type) {
        if (len < 0) {
            return str;
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (count == len) {
                // type = 0 代表prefix，其他代表suffix
                if (type == 0) {
                    return str.substring(0, i);
                }
                return str.substring(i);
            }

            char c = str.charAt(i);
            if (Character.isHighSurrogate(c) || Character.isLowSurrogate(c)) {
                i++;
            }
            count++;
        }

        return str;
    }


    /**
     * 包含emoji表情的字符串实际长度
     *
     * @param str 原有str
     * @return str实际长度
     */
    private static int realStringLength(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isHighSurrogate(c) || Character.isLowSurrogate(c)) {
                i++;
            }
            count++;
        }

        return count;
    }

}
