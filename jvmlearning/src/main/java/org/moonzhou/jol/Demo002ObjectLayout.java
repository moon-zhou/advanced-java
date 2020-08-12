/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo002ObjectLayout.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/8/12 11:29
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * 功能描述: 普通Object的内存布局<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo002ObjectLayout {

    public static void main(String[] args) {
        Object object = new Object();

        System.out.println(ClassLayout.parseInstance(object).toPrintable());
    }
}
