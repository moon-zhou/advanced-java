/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: SimpleDemo.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/8/11 11:20
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.jsonutils.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 功能描述:<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SimpleDemo {

    public static void main(String[] args) {
        AuditLog auditLog = new AuditLog();
        auditLog.setUserNo("123");
        auditLog.setTime(System.currentTimeMillis());
        auditLog.setOpType("add");
        auditLog.setBizType("cache");
        auditLog.setCode("0000");
        auditLog.setExt1("ext1");
//        auditLog.setExt2("ext2");

        auditLog.setInvokeNo(UUID.randomUUID().toString());

        System.out.println(auditLog);

        System.out.println(JSON.toJSONString("123123123123"));

        Object obj = JSONObject.parse("123");
        System.out.println(obj);

        JSONObject obj2 = JSON.parseObject("{result:true}");
        System.out.println(obj2.get("result"));

        Map<String, Object> result = new HashMap<>();
        result.put("result", "success");
        result.put("birthPrivilegeData", "123");
        System.out.println(JSON.toJSONString(result));
    }

}

class AuditLog {
    /**
     * 系统名称
     */
    private String system = "FMGS-ADMIN";

    /**
     * 工号
     */
    private String userNo;

    /**
     * 操作时间(long)
     */
    private Long time;

    /**
     * 操作标识-方法名
     */
    private String opType;

    /**
     * 业务标识
     */
    private String bizType;

    /**
     * 编码
     */
    private String code;

    /**
     * 扩展查询字段1,普通字符串或数字型
     */
    private String ext1 = "";

    /**
     * 扩展查询字段2，普通字符串或数字型
     */
    private String ext2 = "";

    /**
     * 扩展信息,json格式
     */
    private String msg = "{}";

    /**
     * 调用流水号，仅用于MDC，不输出到日志具体内容里面
     */
    @JSONField(serialize = false)
    private String invokeNo;

    /**
     * 用户信息，用于日志扩展参数
     */
    @JSONField(serialize = false)
    private String user;

    public AuditLog() {
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getInvokeNo() {
        return invokeNo;
    }

    public void setInvokeNo(String invokeNo) {
        this.invokeNo = invokeNo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}