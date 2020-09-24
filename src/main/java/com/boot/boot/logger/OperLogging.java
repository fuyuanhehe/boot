package com.boot.boot.logger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 说明：日志注解
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface OperLogging {
    // 0:增加;1:修改;2:删除,3查询
    int operType() default 3;

    // 操作内容,默认空
    String content() default "";

    // 备注（预留字段，暂时无用）
    String remark() default "";
}
