/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: TestMask.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/6/2 9:46
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.dailyprogramming;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能描述: 测试日志隐位<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TestMask {

    public static void main(String[] args) {
        String msg = "2021-06-02 09:22:29,672|default task-54|3b3e6519b6354a9698c1746dd5f8f579|DEBUG|SensitiveConverter|日志脱敏 结束:prefix=EPP-EPW{\"code\":\"0000\",\"method\":\"useraccount-modBindMobile-mod-bind-mobile!validateMobileCheckCode.action\",\"time\":12}";
        System.out.println(convert(msg));
    }

    private static final String INCLUDES = "includes";
    private static final String EXCLUDES = "excludes";

    private static final String REGEX_LETTER = "[a-zA-Z]";

    /**
     * key后面为空格，不需要按规则隐位
     */
    private static final String BLANK_STRING = " ";
    private static final String SPECIAL_CHAR = "!|.|-";

    public static String convert(String oriLogMsg) {

        // 获取原始日志
        try {
            // 获取脱敏后的日志
            String afterLogMsg = invokeMsg(oriLogMsg);
            return afterLogMsg;
        } catch (Exception e) {
            return oriLogMsg;
        }
    }

    public static String invokeMsg(final String oriMsg) {
        String tempMsg = oriMsg;
        // 处理字符串
        // 脱敏字段
        String includes = "mobile|userName|accountName|userAlias|mobileAlias|emailAlias|bindMobile|telephone|alias|mobilePhoneNo|password|confirmPassword|email|phoneNum|eppAccountName|name|idNO|identNum|idNo|plainData|newMobile|newInfo|oldMobile|formerInfo|bankCard|formerCellNo|cardHolderName|docNo|certNo";
        String excludes = "imageBest|idType|username|realName|address|occupation|city|province|district|contactAddress";
        int index = -1;
        String[] arr1 = StringUtils.split(includes, "\\|");
        for (String tmKey : arr1) {
            tempMsg = tuominTmp(tempMsg, tmKey, index, includes, INCLUDES);
        }
        String[] arr2 = StringUtils.split(excludes, "\\|");
        for (String tmKey : arr2) {
            tempMsg = tuominTmp(tempMsg, tmKey, index, excludes, EXCLUDES);
        }
        return tempMsg;
    }

    private static String tuominTmp(String tempMsg, String key, int index, String cludes, String type) {
        index = tempMsg.indexOf(key, index + 1);

        //key值的后面一位
        int nextIndex = index + key.length();
        //防止下标越界
        if (tempMsg.length() > nextIndex) {
            //key字段后一位是字母则该字段不是需要脱敏的字段，为空格也不需要脱敏
            String ch = tempMsg.charAt(nextIndex) + "";
            if (match(REGEX_LETTER, ch) || BLANK_STRING.equals(ch) || match(SPECIAL_CHAR, ch)) {
                return tempMsg;
            }
        } else {
            return tempMsg;
        }

        if (index != -1) {
            // 寻找值的开始位置
            int valueStart = getValueStartIndex(tempMsg, index + key.length());
            // 查找值的结束位置（逗号，分号）........................
            int valueEnd = getValuEndEIndex(tempMsg, valueStart);
            // 对获取的值进行脱敏
            String subStr = tempMsg.substring(valueStart, valueEnd);
            subStr = tuomin(subStr, key, cludes, type);
            String tempMsg1 = tempMsg.substring(valueEnd);
            String tempMsg2 = tuominTmp(tempMsg1, key, -1, cludes, type);
            tempMsg = tempMsg.substring(0, valueStart) + subStr + tempMsg2;
        }
        return tempMsg;
    }

    /**
     * 获取value值的开始位置
     *
     * @param msg        要查找的字符串
     * @param valueStart 查找的开始位置
     * @return
     */
    private static int getValueStartIndex(String msg, int valueStart) {
        // 寻找值的开始位置.................................
        char ch;
        do {
            if (valueStart >= msg.length()) {//值的开始位置大于等于msg长度直接返回 如： custNo=XXX, userNo=XXX, userName
                break;
            }
            ch = msg.charAt(valueStart);
            if (valueStart + 1 >= msg.length()) { //值开始位置后一位大于等于msg长度直接返回 如： [result={custNo=XXX, userNo=XXX, userName=XXX}, bindMobile]
                break;
            }
            if (ch == ':' || ch == '=' || ch == '[' || ch == '>') { // key与 value的分隔符
                valueStart++;
                ch = msg.charAt(valueStart);
                if (ch == '"') {
                    valueStart++;
                }
                break; // 找到值的开始位置
            } else {
                valueStart++;
            }
        } while (true);
        return valueStart;

    }

    /**
     * 获取value值的结束位置
     *
     * @return
     */
    private static int getValuEndEIndex(String msg, int valueEnd) {
        do {
            if (valueEnd >= msg.length()) {
                break;
            }
            char ch = msg.charAt(valueEnd);

            if (ch == '"') { // 引号时，判断下一个值是结束，分号还是逗号决定是否为值的结束
                if (valueEnd + 1 >= msg.length()) {
                    break;
                }
                char nextCh = msg.charAt(valueEnd + 1);
                if (nextCh == ';' || nextCh == ',' || nextCh == '＿' || nextCh == '}' || nextCh == '"' || nextCh == ']' || nextCh == '|' || nextCh == '<' || nextCh == ' ') {
                    // 去掉前面的 \ 处理这种形式的数据
                    while (valueEnd > 0) {
                        char preCh = msg.charAt(valueEnd - 1);
                        if (preCh != '\\') {
                            break;
                        }
                        valueEnd--;
                    }
                    break;
                } else {
                    valueEnd++;
                }
            } else if (ch == ';' || ch == ',' || ch == '}' || ch == '＿' || ch == '"' || ch == ']' || ch == '|' || ch == '<' || ch == '&') {
                break;
            } else {
                valueEnd++;
            }

        } while (true);
        return valueEnd;
    }

    private static String tuomin(String submsg, String key, String cludes, String type) {

        SensitiveInfoUtils instance = SensitiveInfoUtils.getInstance();
        String tuminStr = (String) instance.process(key, submsg, cludes, type);
        return tuminStr;
    }

    private static boolean match(String regex, String str) {
        // 为空一定不匹配
        if (StringUtil.isAnyNullOrEmpty(regex, str)) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();

    }

    static class  StringUtil {
        public static boolean isAnyNullOrEmpty(String... strs) {
            for (String str : strs) {
                if (str == null || str.trim().length() == 0) {
                    return true;
                }
            }
            return false;
        }
    }

    static class SensitiveInfoUtils {

        private static final String INCLUDES = "includes";
        private static SensitiveInfoUtils instance = new SensitiveInfoUtils();

        public static SensitiveInfoUtils getInstance() {

            if (null == instance) {
                instance = new SensitiveInfoUtils();
            }

            return instance;
        }


        public Object process(String name, Object value, String cludes, String type) {


            String[] cludesArr = StringUtils.split(cludes, "\\|");

            for (String clude : cludesArr) {
                if (StringUtils.equals(clude, name)) {
                    if (StringUtils.equals(type, INCLUDES)) {
                        // 隐位字段值的最后一位，使用"*"代替
                        return maskValue(String.valueOf(value));
                    } else {
                        return maskExcludeValue(String.valueOf(value));
                    }
                }
            }
            return value;
        }

        /**
         * 功能描述: <br>
         * 〈密码等特殊属性不展示，隐位*代替〉
         *
         * @param value
         * @return
         * @see [相关类/方法](可选)
         * @since [产品/模块版本](可选)
         */
        private String maskExcludeValue(String value) {
            if ("null".equals(value)) {
                return null;
            }
            if (StringUtils.isNotBlank(value)) {
                value = "*";
            }
            return value;
        }

        /**
         * 功能描述: <br>
         * 〈入参长度>1,进行最后一位隐位，若长度=0，正常返回，长度=1，则返回*〉
         *
         * @param value 需要隐位的值
         * @return
         * @see [相关类/方法](可选)
         * @since [产品/模块版本](可选)
         */
        private String maskValue(String value) {
            if ("null".equals(value)) {
                return null;
            }
            if (StringUtils.isNotBlank(value)) {
                value = value.substring(0, value.length() - 1) + "*";
            }
            return value;
        }
    }

}
