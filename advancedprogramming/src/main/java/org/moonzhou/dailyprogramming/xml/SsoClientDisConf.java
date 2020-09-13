package org.moonzhou.dailyprogramming.xml;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SsoClientDisConf {

    public static void main(String[] args) {
//        String configContext = readFileToString("E:\\test\\a.xml");
        String configContext = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<sso-client>\n" +
                "<auth-server-url>https://sssiiitttpppaaayyyypassport.cnxxxxxx/ids</auth-server-url>" +
                "<auth-server-url-extend-list effectSwitch=\"on\">" +
                "<auth-server-url-extend>" +
                "<order>1</order>" +
                "<value>https://sssiiitttpppaaayyyysso.cnxxxxxx/ids</value>" +
                "</auth-server-url-extend>" +
                "</auth-server-url-extend-list>\n" +
                "<auth-id-cookie-name>eppAuthId</auth-id-cookie-name>\n" +
                "<secure-token-cookie-name>eppSecureToken</secure-token-cookie-name>\n" +
                "</sso-client>";
        InputStream inputStream = new ByteArrayInputStream(configContext.getBytes());
        SsoClientXMLParser.parseXml(inputStream);

        AuthServerUrlExtendListConfig authServerUrlExtendListConfig = ClientGlobalConfig.init().getAuthServerUrlExtendListConfig();
        System.out.println(authServerUrlExtendListConfig.getAttribute().getEffectSwitch());
        List<AuthServerUrlExtendListConfig.AuthServerUrlExtendConfig> authServerUrlExtendConfig = authServerUrlExtendListConfig.getAuthServerUrlExtendConfig();
        authServerUrlExtendConfig.forEach(authServerUrl->{
            System.out.println(authServerUrl.getOrder() + "-" + authServerUrl.getValue());
        });
    }

    public static String readFileToString(String path) {
        // 定义返回结果
        String xmlStr = "";

        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)), "UTF-8"));// 读取文件
            String thisLine = null;
            while ((thisLine = in.readLine()) != null) {
                xmlStr += thisLine;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException el) {
                }
            }
        }

        // 返回拼接好的JSON String
        return xmlStr;
    }

    /**
     * 〈xml parser〉<br>
     * 〈 used for parsing client.config configuration.〉
     *
     */
    private static class SsoClientXMLParser {

        private static XPath path;

        private static Document doc;

        private static String getString(Object node, String expression) throws XPathExpressionException {
            return (String) path.evaluate(expression, node, XPathConstants.STRING);
        }

        private static Node getNode(Object node, String expression) throws XPathExpressionException {
            return (Node) path.evaluate(expression, node, XPathConstants.NODE);
        }

        public static void parseXml(InputStream is) {
            try {
                DocumentBuilder dbd = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                doc = dbd.parse(is);
                path = XPathFactory.newInstance().newXPath();
                Node rootN = getNode(doc, "sso-client");

                ClientGlobalConfig config = ClientGlobalConfig.init();
                String authServerUrl = getString(rootN, "auth-server-url");
                if (StringUtils.isNotEmpty(authServerUrl)) {
                    config.setAuthServerUrl(authServerUrl);
                }

                // 新增扩展多域名配置
                // 多域名配置抽象父节点，默认节点功能关闭
                AuthServerUrlExtendListConfig authServerUrlExtendListConfig = new AuthServerUrlExtendListConfig();
                AuthServerUrlExtendListConfig.Attribute attribute = authServerUrlExtendListConfig.createAttribute();

                // 取配置多域名节点进行解析
                Node authServerUrlExtendListNode = getNode(rootN, "auth-server-url-extend-list");
                if (null != authServerUrlExtendListNode) {
                    NamedNodeMap attributes = authServerUrlExtendListNode.getAttributes();
                    Node effectSwitchNode = attributes.getNamedItem("effectSwitch");

                    // 如果配置了多域名节点，并且节点开关打开，则获取数据值
                    if (null != effectSwitchNode && "on".equals(effectSwitchNode.getNodeValue())) {
                        // 设置多域名配置节点-属性：开关打开
                        attribute.setEffectSwitch("on");

                        NodeList childNodes = authServerUrlExtendListNode.getChildNodes();
                        if (null != childNodes) {

                            // 多域名配置抽象子结点
                            List<AuthServerUrlExtendListConfig.AuthServerUrlExtendConfig> authServerUrlExtendConfigList
                                    = new ArrayList<AuthServerUrlExtendListConfig.AuthServerUrlExtendConfig>();

                            int length = childNodes.getLength();

                            for (int i = 0; i < length; i++) {
                                // 扩展域名配置节点，最终配置有顺序要求，先order，再value
                                Node authServerUrlExtend = childNodes.item(i);

                                // 解析值配置项，order-->value，只读取有效的域名
                                int order = Integer.valueOf(authServerUrlExtend.getChildNodes().item(0).getTextContent());
                                if (order > 0) {
                                    AuthServerUrlExtendListConfig.AuthServerUrlExtendConfig authServerUrlExtendConfig
                                            = authServerUrlExtendListConfig.createSubNode();
                                    String value = authServerUrlExtend.getChildNodes().item(1).getTextContent();
                                    authServerUrlExtendConfig.setOrder(order);
                                    authServerUrlExtendConfig.setValue(value);

                                    // 设置多域名配置节点-域名配置
                                    authServerUrlExtendConfigList.add(authServerUrlExtendConfig);
                                }
                            }

                            // 进行多域名按优先级排序1,2,3...
                            Collections.sort(authServerUrlExtendConfigList, authServerUrlExtendListConfig.createSubNode());

                            // 设置多域名配置节点-域名配置
                            authServerUrlExtendListConfig.setAuthServerUrlExtendConfig(authServerUrlExtendConfigList);
                        }
                    }

                }
                // // 设置多域名配置节点-属性：开关打开
                authServerUrlExtendListConfig.setAttribute(attribute);
                config.setAuthServerUrlExtendListConfig(authServerUrlExtendListConfig);


                String authIdCookieName = getString(rootN, "auth-id-cookie-name");
                if (StringUtils.isNotEmpty(authIdCookieName)) {
                    config.setAuthIdCookieName(authIdCookieName);
                }

                String secureTokenCookieName = getString(rootN, "secure-token-cookie-name");
                if (StringUtils.isNotEmpty(secureTokenCookieName)) {
                    config.setSecureTokenCookieName(secureTokenCookieName);
                }


            }  catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (is != null) {
                        is.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
