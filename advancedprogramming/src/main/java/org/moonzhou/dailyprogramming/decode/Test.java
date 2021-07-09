/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: Test.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/7/7 17:33
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.dailyprogramming.decode;

/**
 * 功能描述:<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Test {
    public static void main(String[] args) {
        String input = "307802204D2028394627F153767AAD70487892B03F8EEACCCFC6F6E217C64B3EA64C0EB8022010C82F7B10EBFE43E875C4F25C082E2783969C4ACBFDD8734665440DE2C81AF40420E120CD9018E503A9151B6443D647CB5B408D56B39779A5448700177041A4AD3504100B3A5BDDB588C513FFB67D362F842FE9";

        byte[] inputBase64SafeDecode = UrlSafeBase64.decode(input);
        String inputCipher = StringUtils.newStringUtf8(inputBase64SafeDecode);
        String inputCipher2 = new String(inputBase64SafeDecode);

        String inputCipher3 = new String(input);



        System.out.println(inputCipher);
        System.out.println(inputCipher2);
        System.out.println(inputCipher3);
    }
}
