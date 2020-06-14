package org.moonzhou.jsonutils.fastjson;

import com.alibaba.fastjson.serializer.ValueFilter;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * fastjson里输出字符过滤
 *
 * @author moon-zhou <ayimin1989@163.com>
 * @version V1.0.0
 * @description
 * @date 2020/6/14 20:37
 * @since 1.0
 */
public class FastJsonValueFilter implements ValueFilter {

    /**
     * 工具类，饿汉单例，简单处理
     */
    private static FastJsonValueFilter instance = new FastJsonValueFilter();

    public static FastJsonValueFilter getInstance() {

        if (null == instance) {
            instance = new FastJsonValueFilter();
        }

        return instance;
    }


    /**
     * 过滤参数字段，包含字段内容，隐位掉部分内容
     */
    private final Set<String> includes = new HashSet<String>() {
        /**
         */
        private static final long serialVersionUID = 7661624449941012689L;

        {
            add("idNo");// 证件号
            add("certNo");// 证件号
            add("cardNo");// 卡号

            add("bankCardNo");// 银行卡号
            add("cardNo");// 银行卡号

            add("name");// 真实姓名
            add("realName");// 真实姓名
            add("userName");// 真实姓名
            add("cardHolderName");// 真实姓名

            add("userAlias");// 登录名

            add("bindMobile");// 绑定手机
            add("mobileNo");// 绑定手机
            add("phone");// 绑定手机
            add("mobile");// 绑定手机
            add("phoneNo");// 绑定手机
            add("telephone");// 绑定手机
            add("cardHolderMobileNo");// 绑定手机
        }
    };

    /**
     * 过滤参数字段，包含字段内容，隐位掉全部内容，全部使用*替换掉
     */
    private final Set<String> excludes = new HashSet<String>() {
        /**
         */
        private static final long serialVersionUID = 7661624449941012689L;

        {
            // 加密支付密码
            add("aesPaymentPassword");
            add("encodePayPwd");
            add("payPwd");
            add("aesPaymentPwd");
            add("md5PaymentPassword");
            add("aesSimplePaymentPassword");
            add("payPassword");
            add("paymentPassword");
            add("md5PaymentPwd");

            // 登陆密码
            add("loginPwd");
            add("aesLoginPassword");
            add("aesLoginPwd");
            add("rsaLoginPwd");
            add("md5LoginPassword");
            add("md5LoginPwd");
            add("password");

            // 图片字符流，大文件
            add("facePhoto");
            add("image");
            add("faceImg");
            add("realImg");
            add("img");//调用外部渠道添加绑脸信息，人脸照片

            // 验证码屏蔽
            add("code");
            add("phoneCode");
            add("smsCode");
        }
    };

    @Override
    public Object process(Object object, String name, Object value) {
        if (includes.contains(name)) {
            return maskValue(String.valueOf(value));
        }

        if (excludes.contains(name)) {
            return maskExcludeValue(String.valueOf(value));
        }
        return value;
    }

    /**
     * 功能描述: <br>
     * 〈密码等特殊属性不展示，隐位*代替〉
     *
     * @param value
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private String maskExcludeValue(String value) {
        if ("null".equals(value)) {
            return null;
        }
        if (StringUtils.hasLength(value)) {
            value = "*";
        }
        return value;
    }

    /**
     * 功能描述: <br>
     * 〈入参长度>1,进行最后一位隐位，若长度=0，正常返回，长度=1，则返回*〉
     *
     * @param value 需要隐位的值
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private String maskValue(String value) {
        if ("null".equals(value)) {
            return null;
        }
        if (StringUtils.hasLength(value)) {
            value = value.substring(0, value.length() - 1) + "*";
        }
        return value;
    }

}
