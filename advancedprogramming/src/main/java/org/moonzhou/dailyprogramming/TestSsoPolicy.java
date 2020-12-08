/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Test.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/11/6 17:12
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.dailyprogramming;

import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 功能描述:<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TestSsoPolicy {

    private static String DEFAULT_PATH_SEPARATOR = "/";

    private static AntPathMatcher pathMatcher = new AntPathMatcher();
    private static Map<String, AccessPolicy> lastSegmentUriCache = new ConcurrentHashMap<String, AccessPolicy>();
    private static Map<String, AccessPolicy> matchedUriCache = new ConcurrentHashMap<String, AccessPolicy>();

    private static List<String> passThoughPatterns = new ArrayList<String>();
    private static List<String> gatewayPatterns = new ArrayList<String>();


    static {
        /*lastSegmentUriCache.put("/subWayRed/tranOut*.htm", AccessPolicy.GATEWAY);
        lastSegmentUriCache.put("/subWayRed/index.htm", AccessPolicy.GATEWAY);*/

        passThoughPatterns.add("/subWayRed/tran.htm#/metroRedPacketForWap");


        gatewayPatterns.add("/subWayRed/tranOut*.htm");
        gatewayPatterns.add("/subWayRed/index.htm");
    }

    public static void main(String[] args) {

        System.out.println(matchAccessPolicy("/subWayRed/index.htm"));
        System.out.println(matchAccessPolicy("/subWayRed/tranOutEgo.htm"));
        System.out.println(matchAccessPolicy("/subWayRed/tranOut.htm"));
        System.out.println(matchAccessPolicy("/subWayRed/tranOut111.htm"));
        System.out.println(matchAccessPolicy("/subWayRed/tranOutEgo.htm#/index"));
    }

    public static boolean matching(String uri, List<String> patterns) {
        if (patterns == null || patterns.isEmpty()) {
            return false;
        }
        for (String pattern : patterns) {
            if (pathMatcher.match(pattern, uri)) {
                return true;
            }
        }
        return false;
    }

    public static AccessPolicy matchAccessPolicy(String uri) {
        AccessPolicy policy = null;
        int pathSeparatorIndex = uri.lastIndexOf(DEFAULT_PATH_SEPARATOR);
        if (pathSeparatorIndex >= 0) {
            String lastSegment = uri.substring(pathSeparatorIndex).trim();
            policy = lastSegmentUriCache.get(lastSegment);
            if (policy != null) {
                return policy;
            }
        }
        policy = matchedUriCache.get(uri);
        if (policy != null) {
            return policy;
        }

        if (matching(uri, passThoughPatterns)) {
            policy = AccessPolicy.PASS_THOUGH;
        } else if (matching(uri, gatewayPatterns)) {
            policy = AccessPolicy.GATEWAY;
        } else {
            policy = AccessPolicy.RESTRICTED;
        }

        matchedUriCache.put(uri, policy);
        return policy;
    }

    public enum AccessPolicy {
        RESTRICTED, PASS_THOUGH, GATEWAY
    }

}
