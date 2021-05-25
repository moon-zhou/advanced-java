/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: Demo003SimpleDataFormatConcurrency.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/5/24 16:30
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.concurrency.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 功能描述:<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo003SimpleDataFormatConcurrency {
    // SimpleDateFormat is not thread-safe, so give one to each thread
    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd HHmm");
        }
    };

    // 对外提供该方法，get时，如果当前线程无ThreadLocal，会自动调用initialValue，同时创建ThreadLocalMap
    // 该方法可以修改为static
    //    public static String formatIt(Date date) {
    public String formatIt(Date date) {
        return formatter.get().format(date);
    }

}
