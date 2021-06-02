/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: TestConcatTicket.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/6/2 16:38
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.dailyprogramming;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能描述: 测试拼接参数<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TestConcatTicket {

    private static final Pattern NON_PRINTABLE =
            Pattern.compile("[\\x00-\\x19\\x7F]+");

    public static void main(String[] args) {

        String url = "https://sffsxgpre.cnsuning.com/sffs/teamFund/app.htm#/share?miniClickID=snjr_adid_1622615437341&emjsToken=162261543921381734ffcab00b71e4fd080b12425d6756549&verifyInfoType=12&pctoken2=TWy92o179cb6ab020QSih4aa";
        String url2 = "https://sffsxgpre.cnsuning.com/sffs/teamFund/app.htm?miniClickID=snjr_adid_1622615437341&emjsToken=162261543921381734ffcab00b71e4fd080b12425d6756549&verifyInfoType=12&pctoken2=TWy92o179cb6ab020QSih4aa#/share";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("ticket", "210*ST5BA739894D06CE31F10A47446A37A28A");
        getRedirectResponse(url, parameters);
        getRedirectResponse(url2, parameters);
    }

    public static void getRedirectResponse(final String url, final Map<String, String> parameters) {
        final StringBuilder builder = new StringBuilder(parameters.size() * 40 + 100);
        boolean isFirst = true;
        final String[] fragmentSplit = sanitizeUrl(url).split("#");
        builder.append(fragmentSplit[0]);
        for (final Map.Entry<String, String> entry : parameters.entrySet()) {
            if (entry.getValue() != null) {
                if (isFirst) {
                    builder.append(url.contains("?") ? "&" : "?");
                    isFirst = false;
                } else {
                    builder.append("&");
                }
                builder.append(entry.getKey());
                builder.append("=");
                try {
                    builder.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                } catch (final Exception e) {

                    builder.append(entry.getValue());
                }
            }
        }
        if (fragmentSplit.length > 1) {
            builder.append("#");
            builder.append(fragmentSplit[1]);
        }

        System.out.println(builder.toString());
    }

    private static String sanitizeUrl(final String url) {
        final Matcher m = NON_PRINTABLE.matcher(url);
        final StringBuffer sb = new StringBuffer(url.length());
        boolean hasNonPrintable = false;
        while (m.find()) {
            m.appendReplacement(sb, " ");
            hasNonPrintable = true;
        }
        m.appendTail(sb);
        if (hasNonPrintable) {
            System.out.println("The following redirect URL has been sanitized and may be sign of attack:\n" + url);
        }
        return sb.toString();
    }
}
