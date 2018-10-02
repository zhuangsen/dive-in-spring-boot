package com.zs.web.config;

import com.zs.web.http.converter.properties.PropertiesHttpMessageConverter;
import com.zs.web.method.support.PropertiesHandlerMethodArgumentResolver;
import com.zs.web.method.support.PropertiesHandlerMethodReturnValueHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Rest {@link WebMvcConfigurer} 实现
 */
@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {
    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @PostConstruct
    public void init(){
        // 获取当前 RequestMappingHandlerAdapter 所有的 Resolver 对象
        List<HandlerMethodArgumentResolver> resolvers = requestMappingHandlerAdapter.getArgumentResolvers();
        List<HandlerMethodArgumentResolver> newResolvers = new ArrayList<>(resolvers.size()+1);
        // 添加 PropertiesHandlerMethodArgumentResolver 到集合首位
        newResolvers.add(new PropertiesHandlerMethodArgumentResolver());
        // 添加 已注册的 Resolver 对象集合
        newResolvers.addAll(resolvers);
        // 重新设置 Resolver 对象集合
        requestMappingHandlerAdapter.setArgumentResolvers(newResolvers);

        List<HandlerMethodReturnValueHandler> handlers = requestMappingHandlerAdapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> newHandlers = new ArrayList<>(handlers.size()+1);
        // 添加 PropertiesHandlerMethodReturnValueHandler 到集合首位
        newHandlers.add(new PropertiesHandlerMethodReturnValueHandler());
        // 添加 已注册的 handlers 对象集合
        newHandlers.addAll(handlers);
        // 重新设置 handlers 对象集合
        requestMappingHandlerAdapter.setReturnValueHandlers(newHandlers);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //不建议添加到 converters 的末尾
//        converters.add(new PropertiesHttpMessageConverter());
//        converters.set(0,new PropertiesHttpMessageConverter());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//        //添加 PropertiesHandlerMethodArgumentResolver 到首位
//        //添加自定义 HandlerMethodArgumentResolver，优先级低于内建 HandlerMethodArgumentResolver
//        if(resolvers.isEmpty()){
//            resolvers.add(new PropertiesHandlerMethodArgumentResolver());
//        }else {
//            resolvers.set(0, new PropertiesHandlerMethodArgumentResolver());
//        }

    }
}