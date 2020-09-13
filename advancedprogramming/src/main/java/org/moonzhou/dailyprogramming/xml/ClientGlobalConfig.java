package org.moonzhou.dailyprogramming.xml;

/**
 * 〈客户端全局配置〉<br>
 * 〈功能详细描述〉
 */
public class ClientGlobalConfig {

    private ClientGlobalConfig() {
    }

    // 使用volatile 保证其线程间的可见性
    private volatile static ClientGlobalConfig instance = null;

    private static synchronized void getInstance() {
        if (instance == null) {
            instance = new ClientGlobalConfig();
        }
    }

    public static ClientGlobalConfig init() {

        if (instance == null) {

            getInstance();
        }

        return instance;

    }

    /**
     * sso服务端地址
     */
    private String authServerUrl;

    /**
     * 扩展的sso服务端地址
     */
    private AuthServerUrlExtendListConfig authServerUrlExtendListConfig;

    /**
     * authId 放在cookie的名称
     */
    private String authIdCookieName = "eppAuthId";
    /**
     * secureToken 在cookie的名称
     */
    private String secureTokenCookieName = "eppSecureToken";

    /**
     * @param authServerUrl the authServerUrl to set
     */
    protected void setAuthServerUrl(String authServerUrl) {
        this.authServerUrl = authServerUrl;
    }

    public AuthServerUrlExtendListConfig getAuthServerUrlExtendListConfig() {
        return authServerUrlExtendListConfig;
    }

    public void setAuthServerUrlExtendListConfig(AuthServerUrlExtendListConfig authServerUrlExtendListConfig) {
        this.authServerUrlExtendListConfig = authServerUrlExtendListConfig;
    }

    public void setAuthIdCookieName(String authIdCookieName) {
        this.authIdCookieName = authIdCookieName;
    }

    public void setSecureTokenCookieName(String secureTokenCookieName) {
        this.secureTokenCookieName = secureTokenCookieName;
    }

}
