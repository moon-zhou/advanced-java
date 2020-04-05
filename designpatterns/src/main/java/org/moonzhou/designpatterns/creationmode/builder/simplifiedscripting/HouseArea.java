package org.moonzhou.designpatterns.creationmode.builder.simplifiedscripting;

/**
 * @Description 房屋所属区域
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/5
 */
public enum HouseArea {

    XUANWU,
    QINGHUAI,
    JIANYE,
    GULOU,
    PUKOU,
    QIXIA,
    YUHUA,
    JIANGNING,
    LUHE,
    LISHUI,
    GAOCHUN,
    ;

    @Override
    public String toString() {
        return name().toString();
    }
}
