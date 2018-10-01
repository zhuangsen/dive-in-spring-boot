package com.zs.web.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot 视图引导类
 */
@SpringBootApplication(scanBasePackages = "com.zs.web")
public class SpringBootViewBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootViewBootstrap.class, args);
    }
}