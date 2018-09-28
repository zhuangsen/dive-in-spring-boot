package com.zs.diveinspringboot.bootstrap;

import com.zs.diveinspringboot.annotation.EnableHelloWorld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@EnableHelloWorld
public class EnableHelloWorldBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        //helloWorld Bean是否存在
        String helloWorld =
                context.getBean("helloWorld", String.class);
        System.out.println("helloWorld Bean:" + helloWorld);

        //关闭上下文
        context.close();
    }
}
