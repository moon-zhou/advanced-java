package org.moonzhou.advancedprogramming.annotation.demo001json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建JsonField注解<br>
 *
 * 运行时依然有效，且作用于字段上
 *
 * 参考：https://juejin.im/post/5e911eca6fb9a03c485777d6
 *
 * @author moon-zhou
 * @date: 2020/4/13 17:32
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface JsonField {
    public String value() default "";
}
