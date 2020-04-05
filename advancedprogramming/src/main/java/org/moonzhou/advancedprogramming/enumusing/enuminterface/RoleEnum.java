package org.moonzhou.advancedprogramming.enumusing.enuminterface;

/**
 * 角色枚举，不同角色实现不同操作
 *
 * @author moon-zhou
 * @date: 2020/3/18 19:39
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum RoleEnum implements RoleOperation {

    /**
     * 系统管理员
     */
    ROLE_ROOT_ADMIN {
        /**
         * 角色操作抽象接口方法
         *
         * @return
         */
        @Override
        public String operate() {
            return "Role: " + "root admin";
        }
    },

    /**
     * 会员管理员
     */
    ROLE_MEMBER_ADMIN {
        /**
         * 角色操作抽象接口方法
         *
         * @return
         */
        @Override
        public String operate() {
            return "Role: " + "member admin";
        }
    },

    /**
     * 普通用户
     */
    ROLE_NORMAL {
        /**
         * 角色操作抽象接口方法
         *
         * @return
         */
        @Override
        public String operate() {
            return "Role: " + "normal";
        }
    },

    ;
}
