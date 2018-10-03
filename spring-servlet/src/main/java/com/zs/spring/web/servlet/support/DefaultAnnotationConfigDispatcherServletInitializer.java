package com.zs.spring.web.servlet.support;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Spring Web MVC 自动装配 默认实现
 */
@ComponentScan(basePackages = "com.imooc.spring.web.servlet.controller")
//@Configuration
public class DefaultAnnotationConfigDispatcherServletInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() { // web.xml
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() { // DispatcherServlet
        return new Class[]{
                getClass() // 返回当前类
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
