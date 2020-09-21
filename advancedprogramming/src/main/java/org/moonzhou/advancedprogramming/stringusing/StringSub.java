/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: StringSub.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/9/14 10:57
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.stringusing;

import org.apache.commons.lang3.StringUtils;

/**
 * 功能描述:<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StringSub {
    public static void main(String[] args) {
        String domain = "https://xgpresfsso.cnsuning.com/ids/login";

        System.out.println(StringUtils.substringBefore(domain, "/login"));

        String domain2 = "https://paysso.suning.com/ids/login";
        System.out.println(StringUtils.substringBefore(domain2, "/ids/login"));
        System.out.println(StringUtils.substringBefore(domain2, "ids/login"));
        System.out.println(StringUtils.substringBefore(domain2, "/ids"));
    }
}
