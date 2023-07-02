package org.gweep.springjpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;


@Configuration
@EnableJpaRepositories("org.gweep.springjpa.repository")
@ComponentScan("org.gweep.springjpa")
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class Config {

    private Environment env;

    public Config(Environment env) {
        super();
        this.env = env;
    }

    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan("org.gweep.springjpa.entity");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactory.setJpaProperties(properties());
        return entityManagerFactory;
    }

     private Properties properties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
//        hibernateProperties.setProperty("logging.level.org.springframework.transaction.interceptor", env.getProperty("logging.level.org.springframework.transaction.interceptor"));
//        hibernateProperties.setProperty("logging.level.com.zaxxer.hikari.pool.HikariPool", env.getProperty("logging.level.com.zaxxer.hikari.pool.HikariPool"));
        return hibernateProperties;
    }

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(Objects.requireNonNull(env.getProperty("jdbc.url")),
                Objects.requireNonNull(env.getProperty("jdbc.user")), Objects.requireNonNull(env.getProperty("jdbc.password")));
    }

    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

}

