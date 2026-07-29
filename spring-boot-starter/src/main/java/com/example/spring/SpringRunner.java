package com.example.spring;

import com.example.spring.config.DatabaseProps;
import com.example.spring.repository.ConnectionPool;
import com.example.spring.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Primary;
import org.springframework.core.SpringProperties;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringRunner {


    private final ConnectionPool connectionPool;
    private final DatabaseProps databaseProps;
//    private final UserRepository userRepository;


    public SpringRunner(@Qualifier("connPool") ConnectionPool connectionPool, DatabaseProps databaseProps) {
        this.connectionPool = connectionPool;
        this.databaseProps = databaseProps;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringRunner.class, args);
        System.out.println(SpringProperties.getProperty("test.msg"));
    }

    @PostConstruct
    void init(){
        System.out.println(connectionPool);
        System.out.println(databaseProps);
    }

}
