package org.moonzhou.designpatterns.behavioralmode.chainofresponsibility;

import java.math.BigDecimal;

public class ConsumeOrder implements Order {
    private String payType;
    private BigDecimal amount;

    public ConsumeOrder(String payType, BigDecimal amount) {
        this.payType = payType;
        this.amount = amount;
    }

    @Override
    public String getPayType() {
        return this.payType;
    }

    @Override
    public BigDecimal getAmount() {
        return this.amount;
    }
}