package com.example.spring.config;

import com.example.spring.repository.ConnectionPool;
import com.example.spring.repository.UserRepositoryClass;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean("connPool")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ConnectionPool connectionPool(@Value("${test.msg}") String name) {
        return new ConnectionPool(name);
    }

    @Bean
    public ConnectionPool connectionPool1() {
        return new ConnectionPool("mysql");
    }

    @Bean
    public UserRepositoryClass userRepository(@Qualifier("connectionPool1") ConnectionPool connectionPool){
        return new UserRepositoryClass(connectionPool);
    }
}
