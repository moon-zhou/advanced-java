package org.moonzhou.advancedprogramming.enumusing;

/**
 * 常规枚举功能测试类
 *
 * @author moon-zhou
 * @date: 2020/3/18 20:01
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class App {
    public static void main(String[] args) {
        test();

        testSwitchCaseUsing();

        testMoreAttributeUsing();
    }

    private static void test() {
        // 测试普通用法
        UserRole role1 = UserRole.ROLE_ROOT_ADMIN;
        UserRole role2 = UserRole.ROLE_ORDER_ADMIN;
        UserRole role3 = UserRole.ROLE_NORMAL;

        // values()方法：返回所有枚举常量的数组集合
        for (UserRole role : UserRole.values()) {
            System.out.println(role);
        }
        // 打印：
        // ROLE_ROOT_ADMIN
        // ROLE_ORDER_ADMIN
        // ROLE_NORMAL

        // ordinal()方法：返回枚举常量的序数，注意从0开始
        System.out.println(role1.ordinal()); // 打印0
        System.out.println(role2.ordinal()); // 打印1
        System.out.println(role3.ordinal()); // 打印2

        // compareTo()方法：枚举常量间的比较
        System.out.println(role1.compareTo(role2)); //打印-1
        System.out.println(role2.compareTo(role3)); //打印-2
        System.out.println(role1.compareTo(role3)); //打印-2

        // name()方法：获得枚举常量的名称
        System.out.println(role1.name()); // 打印ROLE_ROOT_ADMIN
        System.out.println(role2.name()); // 打印ROLE_ORDER_ADMIN
        System.out.println(role3.name()); // 打印ROLE_NORMAL

        // valueOf()方法：返回指定名称的枚举常量
        System.out.println(UserRole.valueOf("ROLE_ROOT_ADMIN"));
        System.out.println(UserRole.valueOf("ROLE_ORDER_ADMIN"));
        System.out.println(UserRole.valueOf("ROLE_NORMAL"));
    }

    private static void testSwitchCaseUsing() {
        // Switch-case使用方法
        UserRole userRole = UserRole.ROLE_ORDER_ADMIN;
        switch (userRole) {
            case ROLE_ROOT_ADMIN:  // 比如此处的意义就非常清晰了，比1，2，3这种数字好！
                System.out.println("这是系统管理员角色");
                break;
            case ROLE_ORDER_ADMIN:
                System.out.println("这是订单管理员角色");
                break;
            case ROLE_NORMAL:
                System.out.println("这是普通用户角色");
                break;
        }
    }

    private static void testMoreAttributeUsing() {
        // 测试枚举多属性
        System.out.println(MessageEnum.getMessageByCode("0000"));
        System.out.println(MessageEnum.getMessageByCode("0001"));
        System.out.println(MessageEnum.getMessageByCode("0002"));
    }
}
