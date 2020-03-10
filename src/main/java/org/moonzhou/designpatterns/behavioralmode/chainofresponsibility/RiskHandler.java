package org.moonzhou.designpatterns.behavioralmode.chainofresponsibility;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/3/8 21:12
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class RiskHandler {
    /**
     * 支付方式
     */
    private String payType;

    private RiskHandler nextHandler;

    public RiskHandler(String payType) {
        this.payType = payType;
    }

    /**
     * 是否能支付
     *
     * @param order 订单
     */
    protected abstract boolean canPay(Order order);

    /**
     * 处理器
     *
     * @param order 订单
     * @return 返回true 或者 false
     */
    public final boolean handler(Order order) {
        if (order.getPayType().equals(this.payType)) {
            return this.canPay(order);
        } else {
            if (this.nextHandler != null) {
                return this.nextHandler.handler(order);
            } else {
                throw new IllegalArgumentException("支付方式有误");
            }
        }
    }

    public void setNextHandler(RiskHandler handler) {
        this.nextHandler = handler;
    }
}
