/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Test.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/8/12 11:24
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.jol;

import org.openjdk.jol.vm.VM;

/**
 * 功能描述: 通过jol查看jvm基本信息<br>
 *
 * result：
 * # Running 64-bit HotSpot VM.
 * # Using compressed oop with 3-bit shift.
 * # Using compressed klass with 3-bit shift.
 * # Objects are 8 bytes aligned.
 * # Field sizes by type: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]    --引用句柄, byte, boolean, char, short, int, float, double, long长度
 * # Array element sizes: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
 *
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001VMInfo {
    public static void main(String[] args) {
        System.out.println(VM.current().details());
    }
}
