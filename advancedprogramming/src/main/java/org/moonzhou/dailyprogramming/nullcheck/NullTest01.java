/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: NullTest01.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/10/13 8:56
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.dailyprogramming.nullcheck;

import java.util.Objects;

/**
 * 功能描述: 链式判断为null<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NullTest01 {
    public static void main(String[] args) {

        User axin = new User();

        User.School school = new User.School();

        axin.setName("hello");

        if (Objects.nonNull(axin) && Objects.nonNull(axin.getSchool())) {

            User.School userSc = axin.getSchool();

            System.out.println(userSc.getAdress());

        } else {
            System.out.println("is null...");
        }

    }
}
