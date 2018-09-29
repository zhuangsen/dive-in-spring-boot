package com.zs.diveinspringboot;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplicationEventBootstrap {

    public static void main(String[] args) {
        //创建上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //注册应用事件监听器
        context.addApplicationListener(event -> System.out.println("监听到事件:"+event));

        //启动上下文
        context.refresh();

        context.publishEvent("HelloWorld");
        context.publishEvent("2018");

        //发送事件
        context.publishEvent(new ApplicationEvent("madison") {
        });

        //关闭上下文
        context.close();
    }
}
