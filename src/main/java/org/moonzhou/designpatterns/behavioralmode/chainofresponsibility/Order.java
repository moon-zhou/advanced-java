package org.moonzhou.designpatterns.behavioralmode.chainofresponsibility;

import java.math.BigDecimal;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/3/8 21:13
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface Order {
    /**
     * 获取支付方式
     *
     * @return 支付方式
     */
    String getPayType();

    /**
     * 获取订单金额
     *
     * @return 订单金额
     */
    BigDecimal getAmount();

}
