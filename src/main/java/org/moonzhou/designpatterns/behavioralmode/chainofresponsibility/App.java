package org.moonzhou.designpatterns.behavioralmode.chainofresponsibility;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        // 花呗订单
        ConsumeOrder huabeiOrder = new ConsumeOrder(PayTypeEnum.HUA_BEI.getPayType(), BigDecimal.valueOf(200));

        // 白条订单
        ConsumeOrder baitiaoOrder = new ConsumeOrder(PayTypeEnum.BAI_TIAO.getPayType(), BigDecimal.valueOf(301));

        // 加载风控系统
        PayRiskControlService riskControlService = new PayRiskControlService();

        // 创建订单
        boolean canPayOfHuabei = riskControlService.canPay(huabeiOrder);
        boolean canPayOfBaitiao = riskControlService.canPay(baitiaoOrder);
        System.out.println("canPayOfHuabei = " + canPayOfHuabei);
        System.out.println("canPayOfBaitiao = " + canPayOfBaitiao);
    }
}