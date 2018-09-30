package com.zs.diveinspringboot.listener;

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;

/**
 * Before {@link ConfigFileApplicationListener} 实现
 */
public class BeforeConfigFileApplicationListener implements Ordered, SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
                || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }
    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return true;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent prepareEvent = (ApplicationEnvironmentPreparedEvent) event;
            Environment environment = prepareEvent.getEnvironment();
            System.out.println("environment.getProperty(\"name\"):"+environment.getProperty("name"));

        }
        if (event instanceof ApplicationPreparedEvent) {

        }
    }

    @Override
    public int getOrder() {
//        return ConfigFileApplicationListener.DEFAULT_ORDER - 1;
        return ConfigFileApplicationListener.DEFAULT_ORDER + 1;
    }
}
