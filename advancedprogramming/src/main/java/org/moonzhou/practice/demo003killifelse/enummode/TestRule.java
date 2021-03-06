/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: TestRule.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/10/14 9:56
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.practice.demo003killifelse.enummode;

/**
 * 功能描述: 测试类<br>
 *
 * 通过枚举类来做映射，每次新增实现类，只需要修改映射即可
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TestRule {

    public static void main(String[] args) {
        String ruleName = "risk";

        RuleEnum ruleEnum = RuleEnum.specifyRuleEnum(ruleName);
        DataHandleRule rule = ruleEnum.getRule();
        rule.process();
    }
}
