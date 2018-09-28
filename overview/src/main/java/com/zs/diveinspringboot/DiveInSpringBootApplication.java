package com.zs.diveinspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
//@ServletComponentScan(basePackages = "com.zs.com.zs.diveinspringboot.web.servlet")
public class DiveInSpringBootApplication {

    public static void main(String[] args) {
	    new SpringApplicationBuilder(DiveInSpringBootApplication.class)
                .web(WebApplicationType.NONE)
                .properties("abc=sds")
                .run(args);
//        SpringApplication.run(DiveInSpringBootApplication.class, args);
    }
}
