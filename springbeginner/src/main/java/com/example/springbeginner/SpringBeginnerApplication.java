package com.example.springbeginner;

import com.example.springbeginner.config.ConditionBeanConfig;
import com.example.springbeginner.lifecycle.BeanLifecycle;
import com.example.springbeginner.model.BeanDistribution;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@Configuration
@PropertySource("classpath:application.properties")
public class SpringBeginnerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBeginnerApplication.class, args);

        // take bean from context then can read @Value

        BeanLifecycle beanLifecycle = context.getBean("beanLifecycle", BeanLifecycle.class);
        System.out.println(beanLifecycle);
        ConditionBeanConfig config = context.getBean("conditionBeanConfig", ConditionBeanConfig.class);
        System.out.println(config);
        new SpringBeginnerApplication().check(context, config.getValue());
    }

    private void check(ConfigurableApplicationContext context, String value){
        if(Boolean.parseBoolean(value)) {
            BeanDistribution beanDistribution = context.getBean("beanDistribution", BeanDistribution.class);
            System.out.println(beanDistribution);
        } else {
            BeanDistribution otherBeanDistribution = context.getBean("otherBeanDistribution", BeanDistribution.class);
            System.out.println(otherBeanDistribution);
        }
        context.close();
    }

}
