package org.moonzhou.dailyprogramming.lambda.enumoperation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/8/1 09:59
 */
@Slf4j
public class EnumTest02 {
    public static void main(String[] args) {
        for (FormStatusEnum01 value : FormStatusEnum01.values()) {
            log.info("test enum01: {}, {}, {}", value, value.name(), FormStatusEnum01.valueOf(value.name()));
        }
        log.info("test enum01: {}", FormStatusEnum01.DRAFT);
        log.info("test enum01: {}", FormStatusEnum01.DRAFT.ordinal());
        log.info("test enum01: {}", FormStatusEnum01.SUBMIT.ordinal());

        log.info("---------------------------");
        for (FormStatusEnum02 value : FormStatusEnum02.values()) {
            log.info("test enum02: {}, {}, {}", value, value.name(), FormStatusEnum02.valueOf(value.name()));
        }
        log.info("test enum02: {}", FormStatusEnum02.DRAFT);
        log.info("test enum02: {}", FormStatusEnum02.DRAFT.ordinal());
        log.info("test enum02: {}", FormStatusEnum02.SUBMIT.ordinal());
    }

    @Getter
    @AllArgsConstructor
    enum FormStatusEnum01 {

        DRAFT("01", "draft"),
        SUBMIT("02", "submit"),
        CANCEL("03", "cancel"),
        ;

        private final String status;
        private final String description;
    }

    @Getter
    @AllArgsConstructor
    enum FormStatusEnum02 {

        DRAFT("01", "draft"),
        SUBMIT("02", "submit"),
        CANCEL("03", "cancel"),
        ;

        private final String status;
        private final String description;

        @Override
        public String toString() {
            return "FormStatusEnum02{" +
                    "status='" + status + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }

}
