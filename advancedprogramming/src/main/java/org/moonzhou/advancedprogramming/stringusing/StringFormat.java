/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: StringFormat.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/8/4 15:38
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.stringusing;

import org.apache.commons.lang3.StringUtils;

import java.net.URLEncoder;
import java.util.UUID;

/**
 * 功能描述:<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StringFormat {
    public static void main(String[] args) {
        allParam();

        onlyBackUrlParam();

        onlySceneParam();
    }

    private static void allParam() {
        String noticeUrlId = "40005";
        String signWithOutCardNoUnimark = UUID.randomUUID().toString();

        String sessionBackUrl = "https://www.baidu.com";

        String failBackUrl = "https://aaa.bbb.com/epwm/withoutCardSign/cardListIndex.htm";

        if (StringUtils.isNotBlank(noticeUrlId) && StringUtils.isNotBlank(signWithOutCardNoUnimark)) {
            String urlParam = String.format("?noticeUrlId=%s&signWithOutCardNoUnimark=%s", noticeUrlId, signWithOutCardNoUnimark);
            failBackUrl += urlParam;
        }

        if (StringUtils.isNotBlank(sessionBackUrl)) {
            if (failBackUrl.contains("?")) {
                failBackUrl += "&backUrl=" + encoderData(sessionBackUrl);
            } else {
                failBackUrl += "?backUrl=" + encoderData(sessionBackUrl);
            }
        }

        System.out.println(failBackUrl);
    }

    private static void onlyBackUrlParam() {
        String noticeUrlId = "";
        String signWithOutCardNoUnimark = "";

        String sessionBackUrl = "https://www.baidu.com";

        String failBackUrl = "https://aaa.bbb.com/epwm/withoutCardSign/cardListIndex.htm";

        if (StringUtils.isNotBlank(noticeUrlId) && StringUtils.isNotBlank(signWithOutCardNoUnimark)) {
            String urlParam = String.format("?noticeUrlId=%s&signWithOutCardNoUnimark=%s", noticeUrlId, signWithOutCardNoUnimark);
            failBackUrl += urlParam;
        }

        if (StringUtils.isNotBlank(sessionBackUrl)) {
            if (failBackUrl.contains("?")) {
                failBackUrl += "&backUrl=" + encoderData(sessionBackUrl);
            } else {
                failBackUrl += "?backUrl=" + encoderData(sessionBackUrl);
            }
        }

        System.out.println(failBackUrl);
    }

    private static void onlySceneParam() {
        String noticeUrlId = "40005";
        String signWithOutCardNoUnimark = UUID.randomUUID().toString();

        String sessionBackUrl = "";

        String failBackUrl = "https://aaa.bbb.com/epwm/withoutCardSign/cardListIndex.htm";

        if (StringUtils.isNotBlank(noticeUrlId) && StringUtils.isNotBlank(signWithOutCardNoUnimark)) {
            String urlParam = String.format("?noticeUrlId=%s&signWithOutCardNoUnimark=%s", noticeUrlId, signWithOutCardNoUnimark);
            failBackUrl += urlParam;
        }

        if (StringUtils.isNotBlank(sessionBackUrl)) {
            if (failBackUrl.contains("?")) {
                failBackUrl += "&backUrl=" + encoderData(sessionBackUrl);
            } else {
                failBackUrl += "?backUrl=" + encoderData(sessionBackUrl);
            }
        }

        System.out.println(failBackUrl);
    }

    private static String encoderData(String val) {
        try {
            return URLEncoder.encode(val, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }

    }
}
