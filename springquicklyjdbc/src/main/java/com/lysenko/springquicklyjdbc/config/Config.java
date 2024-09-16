package com.lysenko.springquicklyjdbc.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application-mysql.properties")
//@ComponentScan("com.lysenko.springquicklyjdbc")
public class Config {

//    @Value("${custom.datasource.driver-class-name}")
//    private String driver;
    @Value("${custom.datasource.url}")
    private String url;
    @Value("${custom.datasource.username}")
    private String username;
    @Value("${custom.datasource.password}")
    private String password;

    @Bean
    public DatabasePopulator populator() {
        return new ResourceDatabasePopulator(new ClassPathResource("schema.sql"));
    }

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setConnectionTimeout(1000);
//        dataSource.setDriverClassName(driver);

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


}
