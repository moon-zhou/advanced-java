package org.moonzhou.advancedprogramming.enumusing;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/19
 */
public class EnumMapTest {
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

    public static void main(String[] args) {
        Map<UserRole, Integer> userStatisticMap = new EnumMap<>(UserRole.class);

        List<User> userList = new ArrayList<User>();
        User user1 = new User("moon1", UserRole.ROLE_ROOT_ADMIN);
        User user2 = new User("moon1", UserRole.ROLE_ORDER_ADMIN);
        User user3 = new User("moon1", UserRole.ROLE_NORMAL);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        for (User user : userList) {
            Integer num = userStatisticMap.get(user.getUserRole());
            if (null != num) {
                userStatisticMap.put(user.getUserRole(), num + 1);
            } else {
                userStatisticMap.put(user.getUserRole(), 1);
            }
        }

        System.out.println("result: " + userStatisticMap);
    }
}
