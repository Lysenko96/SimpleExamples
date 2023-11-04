package com.example.springbeginner;

import com.example.springbeginner.config.ConditionBeanConfig;
import com.example.springbeginner.model.BeanDistribution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = ConditionBeanConfig.class)
@SpringBootTest(properties = {"value=true"})
class SpringBeginnerApplicationTests {

    @Autowired
    private BeanDistribution beanDistribution;

    @Value("${value}")
    private String value;

    @Test
    void conditionTest(){
        System.out.println(value);
        boolean flag = Boolean.parseBoolean(value);
        if(flag) Assertions.assertEquals("bean1", beanDistribution.getName());
        if(!flag) Assertions.assertEquals("bean2", beanDistribution.getName());
    }

}
