package com.zs.diveinspringboot.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * Java系统属性 条件判断
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(OnSystemPropertyCondition.class)
@ConditionalOnMissingBean
public @interface ConditionOnSystemProperty {

    /**
     * 系统属性名称
     *
     * @return
     */
    String name();

    /**
     * 系统属性值
     *
     * @return
     */
    String value();
}
