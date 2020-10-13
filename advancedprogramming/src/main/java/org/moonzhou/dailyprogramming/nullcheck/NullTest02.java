/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: NullTest02.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/10/13 16:45
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.dailyprogramming.nullcheck;

/**
 * 功能描述:<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NullTest02 {
    public static void main(String[] args) {

        User axin = new User();

        User.School school = new User.School();

        axin.setName("hello");

        // 1. 基本调用
        String value1 = OptionalBean.ofNullable(axin)
                .getBean(User::getSchool)
                .getBean(User.School::getAdress).get();

        System.out.println(value1);

        // 2. 扩展的 isPresent方法 用法与 Optional 一样
        boolean present = OptionalBean.ofNullable(axin)
                .getBean(User::getSchool)
                .getBean(User.School::getAdress).isPresent();

        System.out.println(present);

        // 3. 扩展的 ifPresent 方法
        OptionalBean.ofNullable(axin)
                .getBean(User::getSchool)
                .getBean(User.School::getAdress)
                .ifPresent(adress -> System.out.println(String.format("地址存在:%s", adress)));

        // 4. 扩展的 orElse
        String value2 = OptionalBean.ofNullable(axin)
                .getBean(User::getSchool)
                .getBean(User.School::getAdress).orElse("家里蹲");

        System.out.println(value2);

        // 5. 扩展的 orElseThrow
        try {

            String value3 = OptionalBean.ofNullable(axin)
                    .getBean(User::getSchool)
                    .getBean(User.School::getAdress).orElseThrow(() -> new RuntimeException("空指针了"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
