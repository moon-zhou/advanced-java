package org.moonzhou.designpatterns.behavioralmode.chainofresponsibility;

public class PayRiskControlService {
    public boolean canPay(Order order) {
        // 设置风控
        RiskHandler creditHandler = new CreditHandler();
        RiskHandler huabeiHandler = new HuabeiHandler();
        RiskHandler baiTiaoHandler = new BaiTiaoHandler();
        creditHandler.setNextHandler(huabeiHandler);
        huabeiHandler.setNextHandler(baiTiaoHandler);
        return creditHandler.handler(order);
    }
}