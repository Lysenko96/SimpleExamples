package com.example.springbeginner.config;

import com.example.springbeginner.model.BeanDistribution;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ConditionBeanConfig {

    @Value("${value}")
    private String value;

    // depends on property value = true/false create different bean

    @ConditionalOnProperty(value = "value", havingValue = "true")
    @Bean
    public BeanDistribution beanDistribution(){
        return new BeanDistribution("bean1");
    }

    @ConditionalOnMissingBean(value = BeanDistribution.class)
    @Bean
    public BeanDistribution otherBeanDistribution(){
        return new BeanDistribution("bean2");
    }

    public String getValue() {
        return value;
    }
}
