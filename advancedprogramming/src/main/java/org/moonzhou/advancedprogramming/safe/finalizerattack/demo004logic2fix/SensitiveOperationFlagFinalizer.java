/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: SensitiveOperationFlagFinalizer.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/9/4 19:38
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.safe.finalizerattack.demo004logic2fix;

import org.moonzhou.advancedprogramming.safe.finalizerattack.demo004logic2fix.SensitiveOperationFlag;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述:<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SensitiveOperationFlagFinalizer extends SensitiveOperationFlag {

    public SensitiveOperationFlagFinalizer() {
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("We try to do store Money action!");
        this.storeMoney();
        System.exit(0);
    }
}
