package com.example.spring.config;

import com.example.spring.repository.ConnectionPool;
import com.example.spring.repository.UserRepository;
import com.example.spring.web.WebConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

@ImportResource("classpath:application.xml")
@Configuration
@Import(WebConfig.class)
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.example.spring")
public class AppConfig {

    @Bean("connPool")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ConnectionPool connectionPool() {
        return new ConnectionPool("connPool123");
    }

    @Bean
    public ConnectionPool connectionPool1() {
        return new ConnectionPool("mysql");
    }

    @Bean
    public UserRepository userRepository(@Qualifier("connectionPool1") ConnectionPool connectionPool){
        return new UserRepository(connectionPool);
    }
}
