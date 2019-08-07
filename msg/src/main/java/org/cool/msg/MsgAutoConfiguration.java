package org.cool.msg;

import org.cool.msg.interceptor.MsgPreValidatorHandlerInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "msg")
@ComponentScan({"org.cool.msg.*"})
public class MsgAutoConfiguration {

    private final ApplicationContext applicationContext;

    public MsgAutoConfiguration(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    @Bean
    public MsgService msgServiceImpl(ApplicationContext applicationContext, MsgPreValidatorHandlerInterceptor preValidatorHandlerInterceptor) {
        return new MsgServiceImpl(applicationContext, preValidatorHandlerInterceptor);
    }
}
