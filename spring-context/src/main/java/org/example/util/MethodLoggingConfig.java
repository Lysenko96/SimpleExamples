package org.example.util;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MethodLoggingConfig {

    @Bean
    public BeanPostProcessor methodLoggingBeanPostProcessor(){
        return new MethodLoggingAnnotationBeanPostProcessor();
    }
}
