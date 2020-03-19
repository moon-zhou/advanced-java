package org.moonzhou.advancedprogramming.enumusing;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/19
 */
public class EnumSetTest {

    public enum UserRole {

        /**
         * 系统管理员
         */
        ROLE_ROOT_ADMIN,

        /**
         * 订单管理员
         */
        ROLE_ORDER_ADMIN,

        /**
         * 普通用户
         */
        ROLE_NORMAL,

    }

    static class User {
        String name;

        UserRole userRole;

        public User(String name, UserRole userRole) {
            this.name = name;
            this.userRole = userRole;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public UserRole getUserRole() {
            return userRole;
        }

        public void setUserRole(UserRole userRole) {
            this.userRole = userRole;
        }
    }

    /**
     * 判断某个进来的用户是不是管理员
     *
     * @param user
     * @return
     */
    static Boolean isAdmin(User user) {
        EnumSet<UserRole> userRoles
                = EnumSet.of(
                UserRole.ROLE_ROOT_ADMIN,
                UserRole.ROLE_ORDER_ADMIN
        );

        /*Set<UserRole> userRoles =new HashSet<>();
        userRoles.add(UserRole.ROLE_ROOT_ADMIN);
        userRoles.add(UserRole.ROLE_ORDER_ADMIN);*/

        if (userRoles.contains(user.getUserRole())) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        User user = new User("moon", UserRole.ROLE_NORMAL);
        System.out.println(isAdmin(user));

        user.setUserRole(UserRole.ROLE_ROOT_ADMIN);
        System.out.println(isAdmin(user));
    }
}
