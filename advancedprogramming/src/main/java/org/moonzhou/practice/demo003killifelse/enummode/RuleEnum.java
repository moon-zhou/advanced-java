/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: RuleEnum.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/10/14 9:08
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.practice.demo003killifelse.enummode;

/**
 * 功能描述: 规则映射枚举类<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum RuleEnum {
    RISK("risk", new RiskRule()),

    SENSITIVE("sensitive", new SensitiveRule()),

    DEFAULT("default", new DefaultRule()),
    ;

    private String ruleName;

    private DataHandleRule rule;

    RuleEnum(String ruleName, DataHandleRule rule) {
        this.ruleName = ruleName;
        this.rule = rule;
    }

    public static RuleEnum specifyRuleEnum(String ruleName) {
        RuleEnum[] ruleEnums = RuleEnum.values();
        for (RuleEnum ruleEnum : ruleEnums) {
            if (ruleEnum.ruleName.equals(ruleName)) {
                return ruleEnum;
            }
        }

        return DEFAULT;
    }

    public DataHandleRule getRule() {
        return rule;
    }
}
