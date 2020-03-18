package org.moonzhou.advancedprogramming.enumusing;

/**
 * 枚举多属性使用demo
 *
 * @author moon-zhou
 * @date: 2020/3/18 19:50
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum MessageEnum {

    SUCCESS("0000", "成功"),

    FAIL_NO_DATA("0001", "查询无果"),

    ;

    private String respongseCode;

    private String resopnseMessage;

    MessageEnum(String respongseCode, String resopnseMessage) {
        this.respongseCode = respongseCode;
        this.resopnseMessage = resopnseMessage;
    }

    public String getRespongseCode() {
        return respongseCode;
    }

    public String getResopnseMessage() {
        return resopnseMessage;
    }

    public static String getMessageByCode(String respongseCode) {
        for (MessageEnum messageEnum : MessageEnum.values()) {
            if (messageEnum.getRespongseCode().equals(respongseCode)) {
                return messageEnum.getResopnseMessage();
            }
        }

        return null;
    }
}
