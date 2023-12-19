package com.example.springbootentitymanager.config;

import com.example.springbootentitymanager.SpringBootEntityManagerApplication;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration

@ComponentScan("com.example.springbootentitymanager")
@EnableJpaRepositories(
        value = "com.example.springbootentitymanager.repository",
        entityManagerFactoryRef = "customEntityManagerFactory",
        transactionManagerRef = "customTransactionManager")
@PropertySource("classpath:application.yaml")
@EnableTransactionManagement
public class EntityManagerConfig {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;

    public DataSource dataSource;

    @Bean("customTransactionManager")
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }

    @Bean("customEntityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("com.example.springbootentitymanager.entity");
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(setHibernateProperties());
        factoryBean.afterPropertiesSet();
        this.dataSource = factoryBean.getDataSource();
        return factoryBean.getNativeEntityManagerFactory();
    }

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(url, user, password);
    }


    // be careful when read property from .yaml need read right name with new line
    // it mistake hibernate: hbm2ddl: auto: create
    // right hibernate.hbm2ddl.auto: create
    private Properties setHibernateProperties() {
        Properties hibernateProperties = new Properties();
        try (InputStream input = SpringBootEntityManagerApplication.class.getClassLoader().getResourceAsStream("application.yaml")) {
            hibernateProperties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hibernateProperties;
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
