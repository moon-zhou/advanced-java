/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: DataHandleRule.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/10/14 8:51
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.practice.demo003killifelse.enummode;

/**
 * 功能描述: 抽象数据处理接口的接口<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@FunctionalInterface
public interface DataHandleRule {
    void process();
}
