package com.zs.diveinspringboot.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.env.ConfigurableEnvironment;

public class HelloWorldRunListener implements SpringApplicationRunListener {

    public HelloWorldRunListener(SpringApplication application, String[] args) {
//        this.application = application;
//        this.args = args;
//        this.initialMulticaster = new SimpleApplicationEventMulticaster();
//        for (ApplicationListener<?> listener : application.getListeners()) {
//            this.initialMulticaster.addApplicationListener(listener);
//        }
    }

    @Override
    public void starting() {
        System.out.println("HelloWorldRunListener starting()...");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void started(ConfigurableApplicationContext context) {

    }

    @Override
    public void running(ConfigurableApplicationContext context) {

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
