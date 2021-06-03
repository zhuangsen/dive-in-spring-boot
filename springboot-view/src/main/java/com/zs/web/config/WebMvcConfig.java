package com.zs.web.config;

import org.apache.catalina.Context;
import org.springframework.boot.autoconfigure.web.servlet.TomcatServletWebServerFactoryCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Configuration
//@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

//   <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
//        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
//        <property name="prefix" value="/WEB-INF/jsp/"/>
//        <property name="suffix" value=".jsp"/>
//    </bean>

    @Bean
    public ViewResolver myViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");

        //ThymeleafViewResolver Ordered.LOWEST_PRECEDENCE - 5
        viewResolver.setOrder(Ordered.LOWEST_PRECEDENCE - 10);
        //优先级高于ThymeleafViewResolver
        //配置ViewResolver 的Content-Type
        viewResolver.setContentType("text/xml;chartset=UTF-8");
        return viewResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                System.out.println("拦截中...");
                return true;
            }
        });
    }

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer() {
        return (factory -> factory.addContextCustomizers(context -> {
            //use.dir
            String relativePath = "springboot-view/src/main/webapp";
            File docBaseFile = new File(relativePath);
            if(docBaseFile.exists()){//路径是否存在
                //解决多模块jsp无法读取的问题
                context.setDocBase(docBaseFile.getAbsolutePath());
            }
        }));
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(true)
                .favorPathExtension(true);
    }
}
