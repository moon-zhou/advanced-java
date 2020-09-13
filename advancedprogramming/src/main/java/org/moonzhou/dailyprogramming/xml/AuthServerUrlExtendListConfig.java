/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: AuthServerUrlExtendConfig.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/9/12 9:14
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.dailyprogramming.xml;

import java.util.Comparator;
import java.util.List;

/**
 * 功能描述: 多域名扩展在单点登录客户单配置中心里的配置项对应抽象类<br>
 *
 * client.config对应的auth-server-url-extend-list配置节点
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AuthServerUrlExtendListConfig {

    /**
     * 节点属性配置
     */
    private Attribute attribute;

    private List<AuthServerUrlExtendConfig> authServerUrlExtendConfig;

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public List<AuthServerUrlExtendConfig> getAuthServerUrlExtendConfig() {
        return authServerUrlExtendConfig;
    }

    public void setAuthServerUrlExtendConfig(List<AuthServerUrlExtendConfig> authServerUrlExtendConfig) {
        this.authServerUrlExtendConfig = authServerUrlExtendConfig;
    }

    public AuthServerUrlExtendConfig createSubNode() {
        return new AuthServerUrlExtendConfig();
    }

    public Attribute createAttribute() {
        return new Attribute();
    }

    /**
     * 多域名扩展对应的每一个域名配置抽象类
     */
    class AuthServerUrlExtendConfig implements Comparator {

        /**
         * 域名配置使用的优先级
         * 有效优先级（越小优先级越高）：1,2,3...
         * 无效优先级（域名阶段性下线使用）：-1
         */
        private int order;

        /**
         * ids域名配置
         * e.g.https://sso.xxxxxx/ids
         */
        private String value;

        public AuthServerUrlExtendConfig() {
        }

        public AuthServerUrlExtendConfig(int order, String value) {
            this.order = order;
            this.value = value;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        /**
         * 1,2,3升序排列
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Object o1, Object o2) {
            AuthServerUrlExtendConfig authServerUrlExtendConfig1 = (AuthServerUrlExtendConfig) o1;
            AuthServerUrlExtendConfig authServerUrlExtendConfig2 = (AuthServerUrlExtendConfig) o2;

            return authServerUrlExtendConfig1.getOrder() - authServerUrlExtendConfig2.getOrder();
        }
    }


    /**
     * 多域名配置父节点的属性抽象类
     */
    class Attribute {
        /**
         * 配置节点是否生效开关（功能回退降级时使用）
         * <code>on</code>：生效
         * <code>off</code>：无效
         */
        private String effectSwitch = "off";

        public Attribute() {
        }

        public String getEffectSwitch() {
            return effectSwitch;
        }

        public void setEffectSwitch(String effectSwitch) {
            this.effectSwitch = effectSwitch;
        }
    }
}
