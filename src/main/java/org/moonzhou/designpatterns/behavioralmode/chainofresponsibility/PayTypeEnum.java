package org.moonzhou.designpatterns.behavioralmode.chainofresponsibility;

public enum PayTypeEnum {
    /**
     * 花呗
     */
    HUA_BEI("hua_bei"),

    /**
     * 白条
     */
    BAI_TIAO("bai_tiao"),

    /**
     * 信用卡
     */
    CREDIT("credit"),

    ;

    private String payType;

    PayTypeEnum(String payType) {
        this.payType = payType;
    }

    public String getPayType() {
        return payType;
    }
}