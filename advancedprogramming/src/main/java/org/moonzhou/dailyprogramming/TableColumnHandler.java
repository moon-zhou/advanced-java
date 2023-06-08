package org.moonzhou.dailyprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author moon zhou
 * @version 1.0
 * @description: table column is huge, mybatis foreach save is duplicated
 * @date 2023/6/8 09:29
 */
public class TableColumnHandler {
    public static void main(String[] args) {
        String column = "sequenceStatus,modelId,modifiedTime,modifier,name,owner,ownerDeptId,ownerDeptQueryCode,send,sequenceNo,"
                + "modelCode,subject,templateName,toApplicant,toByCode,toCustomized,toParticipant,version,workflowInstanceId,"
                + "ccByCode,bcc,bccApplicant,bccByCode,bccCustomized,bccParticipant,body,businessData,cc,ccApplicant,appCode,"
                + "ccCustomized,ccParticipant,createdDeptId,createdTime,creater,deleted,disable,id";

        List<String> result = Arrays.stream(column.split(",")).map(value -> "#{emailTemplate." + value + "}")
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
