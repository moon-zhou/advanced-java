package org.moonzhou.dailyprogramming.lambda.enumoperation;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author moonzhou
 */
public class EnumTest {
    public static void main(String[] args) {
        System.out.println(ACTION_ENUM.getValueById1("0"));
        System.out.println(ACTION_ENUM.getValueById2("1"));

        System.out.println(ACTION_ENUM.getValueById1("-1"));
        System.out.println(ACTION_ENUM.getValueById2("-1"));
    }

    @Getter
    public enum ACTION_ENUM {
        APPROVE("Approve", "0"),
        DECLINE("Decline", "2"),
        MODIFY("Modify", "1"),

        ;

        private String value;

        private String id;

        ACTION_ENUM(String value, String id) {
            this.value = value;
            this.id = id;
        }

        public static String getValueById1(String id) {
            String value = null;
            for (ACTION_ENUM actionEnum : ACTION_ENUM.values()) {
                if (actionEnum.getId().equals(id)) {
                    value = actionEnum.getValue();
                    break;
                }
            }
            return value;
        }

        public static String getValueById2(String id) {
            ACTION_ENUM resultEnum = Arrays.stream(ACTION_ENUM.values()).filter(actionEnum -> actionEnum.getId().equals(id)).findFirst().orElse(null);
            if (null != resultEnum) {
                return resultEnum.getValue();
            }

            return null;
        }


    }
}
