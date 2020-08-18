/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: MapKeyNull.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/8/18 9:28
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.jsonutils.fastjson;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述: fastjson处理value为null时，默认不输出key-{}<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MapValueNull {

    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("aaa", null);

        System.out.println(JSON.toJSONString(params));
    }
}
