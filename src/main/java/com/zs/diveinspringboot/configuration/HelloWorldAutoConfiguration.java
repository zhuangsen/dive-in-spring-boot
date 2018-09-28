package com.zs.diveinspringboot.configuration;

import com.zs.diveinspringboot.annotation.EnableHelloWorld;
import com.zs.diveinspringboot.condition.ConditionOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * Hello World 自动装配
 */
@Configuration //spring 模式注解装配
@EnableHelloWorld //模块装配
@ConditionOnSystemProperty(name = "user.name",value = "madison") //条件装配
public class HelloWorldAutoConfiguration {
}
