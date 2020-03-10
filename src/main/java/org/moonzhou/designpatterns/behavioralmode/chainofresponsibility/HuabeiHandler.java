package org.moonzhou.designpatterns.behavioralmode.chainofresponsibility;

import java.math.BigDecimal;

public class HuabeiHandler extends RiskHandler {
    /**
     * 300 限额
     */
    private BigDecimal limitAmount = BigDecimal.valueOf(300);

    public HuabeiHandler() {
        super(PayTypeEnum.HUA_BEI.getPayType());
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