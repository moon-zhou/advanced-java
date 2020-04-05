package org.moonzhou.designpatterns.behavioralmode.chainofresponsibility;

import java.math.BigDecimal;

public class CreditHandler extends RiskHandler {
    /**
     * 500 限额
     */
    private BigDecimal limitAmount = BigDecimal.valueOf(500);

    public CreditHandler() {
        super(PayTypeEnum.CREDIT.getPayType());
    }

    @Override
    protected boolean canPay(Order order) {
        if (order.getAmount().compareTo(limitAmount) < 0) {
            limitAmount = limitAmount.subtract(order.getAmount());
            return true;
        } else {
            return false;
        }
    }
}