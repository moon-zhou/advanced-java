package org.moonzhou.stringutils;

import org.apache.commons.lang3.StringUtils;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/6/15 16:57
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo004 {
    public static void main(String[] args) {

        System.out.println(maskLastSixChar(null));
        System.out.println(maskLastSixChar(""));
        System.out.println(maskLastSixChar("1"));
        System.out.println(maskLastSixChar("12"));
        System.out.println(maskLastSixChar("123"));
        System.out.println(maskLastSixChar("12345"));
        System.out.println(maskLastSixChar("123456"));
        System.out.println(maskLastSixChar("1234567"));
        System.out.println(maskLastSixChar("12345678"));
    }

    /**
     * 隐位字符串最后三位，不满三位的字符串返回第一个字符且补齐3位
     *
     * @param content
     * @return
     */
    public static String maskLastSixChar(String content) {
        if (StringUtils.isBlank(content)) {
            return "";
        }

        if (content.length() <= 6) {
            content = content.substring(0, 1) + "*****";
        } else {
            content = content.substring(0, content.length() - 6) + "******";
        }

        return content;
    }
}
