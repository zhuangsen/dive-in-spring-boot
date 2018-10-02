package com.zs.web.method.support;

import com.zs.web.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * {@link Properties 类型} {@link HandlerMethodArgumentResolver}
 */
public class PropertiesHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Properties.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //复用 PropertiesHttpMessageConverter
        PropertiesHttpMessageConverter converter = new PropertiesHttpMessageConverter();
        ServletWebRequest servletWebRequest = (ServletWebRequest)webRequest;
        //Servlet Request API
        HttpServletRequest request = servletWebRequest.getRequest();
        HttpInputMessage inputMessage = new ServletServerHttpRequest(request);

        return converter.read(null,null,inputMessage);

//        ServletWebRequest servletWebRequest = (ServletWebRequest)webRequest;
//        //Servlet Request API
//        HttpServletRequest request = servletWebRequest.getRequest();
//        String contentType = request.getHeader("Content-Type");
//        //获取请求头 Content-Type 中的媒体类型
//        MediaType mediaType = MediaType.parseMediaType(contentType);
//        Charset charset = mediaType.getCharset();
//        //当 charset 不存在时，使用UTF-8
//        charset = charset == null ? Charset.forName("UTF-8") : charset;
//
//        //请求输入字节流
//        InputStream inputStream = request.getInputStream();
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,charset);
//
//        //加载字符流成为Properties 对象
//        Properties properties = new Properties();
//        properties.load(inputStreamReader);
//        return properties;
    }
}
