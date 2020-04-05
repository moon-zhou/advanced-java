package org.moonzhou.advancedprogramming.enumusing.enuminterface;

/**
 * 测试 enum + interface，通过该方式消灭if/else
 *
 * @author moon-zhou
 * @date: 2020/3/18 19:47
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class App {
    public static void main(String[] args) {

        String roleName = "ROLE_ROOT_ADMIN";

        System.out.println(RoleEnum.valueOf(roleName).operate());
    }
}
