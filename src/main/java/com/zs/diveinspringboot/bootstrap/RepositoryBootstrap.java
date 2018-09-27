package com.zs.diveinspringboot.bootstrap;

import com.zs.diveinspringboot.repository.MyFirstLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@EnableAutoConfiguration
@ComponentScan(basePackages = "com.zs.diveinspringboot.repository")
public class RepositoryBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        //myFirstLevelRepository Bean是否存在
        MyFirstLevelRepository myFirstLevelRepository =
                context.getBean("myFirstLevelRepository",MyFirstLevelRepository.class);
        System.out.println("myFirstLevelRepository Bean:"+myFirstLevelRepository.toString());

        //关闭上下文
        context.close();
    }
}
