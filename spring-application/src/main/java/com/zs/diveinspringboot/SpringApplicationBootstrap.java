package com.zs.diveinspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * {@link SpringApplication}
 */
//@SpringBootApplication
public class SpringApplicationBootstrap {

    public static void main(String[] args) {
//        SpringApplication.run(ApplicationConfiguration.class, args);

        Set<String> sources = new HashSet<>();
        //配置Class 名称
        sources.add(ApplicationConfiguration.class.getName());
//      SpringApplication springApplication =  new SpringApplication(ApplicationConfiguration.class)
        SpringApplication springApplication = new SpringApplication();
//        springApplication.setSources(Collections.singleton(ApplicationConfiguration.class.getName()));
        springApplication.setSources(sources);
//        springApplication.setWebApplicationType(WebApplicationType.NONE);
        ConfigurableApplicationContext context = springApplication.run(args);
        System.out.println("Bean:"+context.getBean(ApplicationConfiguration.class));
    }

    @SpringBootApplication
    public static class ApplicationConfiguration{

    }
}
