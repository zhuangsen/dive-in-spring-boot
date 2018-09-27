package com.zs.diveinspringboot.bootstrap;

import com.zs.diveinspringboot.condition.ConditionOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 系统属性条件引导类
 */
//@ConditionOnSystemProperty(name = "user.name",value = "ella")
public class ConditionOnSystemPropertyBootstrap {

    @Bean
    @ConditionOnSystemProperty(name = "user.name", value = "madison")
    public String helloWorld(){
        return "Hello,world madison";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionOnSystemPropertyBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloWorld = context.getBean("helloWorld",String.class);
        System.out.println("helloWorld Bean:"+helloWorld);

        //关闭上下文
        context.close();
    }
}
