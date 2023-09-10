package com.example.shoppingcart.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(
        entityManagerFactoryRef = "shoppingcartEntityManagerFactory",
        transactionManagerRef = "shoppingcartTransactionManager",
        basePackages = "com.example.shoppingcart.repository")
@EnableTransactionManagement
public class Config {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.driverClassName}")
    private String driver;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.jpa.properties.hibernate.hbm2ddl.auto}")
    private String hbm2ddl_auto;
    @Value("${spring.jpa.properties.hibernate.show_sql}")
    private String show_sql;
    @Value("${spring.jpa.properties.hibernate.format_sql}")
    private String format_sql;
//    @Value("classpath:schema.sql")
//    private Resource schema;
    @Value("classpath:data.sql")
    private Resource data;

    @Bean("shoppingcartTransactionManager")
    public PlatformTransactionManager shoppingcartTransactionManager() {
        return new JpaTransactionManager(shoppingcartEntityManagerFactory());
    }

    @Bean("shoppingcartEntityManagerFactory")
    public EntityManagerFactory shoppingcartEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan("com.example.shoppingcart.entity");
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactory.setJpaProperties(additionalProperties());
        entityManagerFactory.afterPropertiesSet();
        return entityManagerFactory.getNativeEntityManagerFactory();
    }

    @Bean
    public ResourceDatabasePopulator populator() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(data);
        populator.execute(dataSource());
        return populator;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, user, password);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }

    private Properties additionalProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", hbm2ddl_auto);
        hibernateProperties.setProperty("hibernate.show_sql", show_sql);
        hibernateProperties.setProperty("hibernate.format_sql", format_sql);
        return hibernateProperties;
    }
}
