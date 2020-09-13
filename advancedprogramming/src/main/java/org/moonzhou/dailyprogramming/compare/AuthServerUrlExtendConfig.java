package org.moonzhou.dailyprogramming.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author moon-zhou
 */
public class AuthServerUrlExtendConfig implements Comparator<AuthServerUrlExtendConfig> {

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

    public AuthServerUrlExtendConfig() {
    }

    public AuthServerUrlExtendConfig(int order, String value) {
        this.order = order;
        this.value = value;
    }

    /*@Override
    public int compare(Object o1, Object o2) {
        AuthServerUrlExtendConfig authServerUrlExtendConfig1 = (AuthServerUrlExtendConfig) o1;
        AuthServerUrlExtendConfig authServerUrlExtendConfig2 = (AuthServerUrlExtendConfig) o2;

        return authServerUrlExtendConfig1.getOrder() - authServerUrlExtendConfig2.getOrder();
    }*/

    @Override
    public int compare(AuthServerUrlExtendConfig o1, AuthServerUrlExtendConfig o2) {
        return o1.getOrder() - o2.getOrder();
    }

    public static void main(String[] args) {
        List<AuthServerUrlExtendConfig> list = new ArrayList<>();
        list.add(new AuthServerUrlExtendConfig(-1, "aaa.com"));
        list.add(new AuthServerUrlExtendConfig(1, "aaa.com"));
        list.add(new AuthServerUrlExtendConfig(2, "aaa.com"));
        list.add(new AuthServerUrlExtendConfig(5, "aaa.com"));
        list.add(new AuthServerUrlExtendConfig(3, "aaa.com"));
        list.add(new AuthServerUrlExtendConfig(4, "aaa.com"));

        print(list);

        System.out.println("compare--------------------------");

//        Collections.sort(list, new AuthServerUrlExtendConfig());
        list.sort(new AuthServerUrlExtendConfig());

        print(list);

        System.out.println("fiter-----------------------");

        list = fiter(list);

        print(list);
    }

    private static List<AuthServerUrlExtendConfig> fiter(List<AuthServerUrlExtendConfig> list) {
        ArrayList<AuthServerUrlExtendConfig> responseList = new ArrayList<>();
        list.forEach(authServerUrlExtendConfig -> {
            if (authServerUrlExtendConfig.getOrder() > 0) {
                responseList.add(authServerUrlExtendConfig);
            }
        });

        return responseList;
    }

    private static void print(List<AuthServerUrlExtendConfig> list) {

        list.forEach(authServerUrlExtendConfig -> System.out.println(authServerUrlExtendConfig.getOrder() + ":" + authServerUrlExtendConfig.getValue()));
    }

}

