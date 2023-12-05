package org.example.springcourse.config;

import org.example.springcourse.Start;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@PropertySource("classpath:hibernate.properties")
@ComponentScan("org.example.springcourse")
@EnableTransactionManagement
public class HibernateConfig {

    @Value("${hibernate.connection.url}")
    private String url;
    @Value("${hibernate.connection.username}")
    private String user;
    @Value("${hibernate.connection.password}")
    private String password;
    private static final String FILENAME = "hibernate.properties";

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(url, user, password);
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new LocalSessionFactoryBuilder(dataSource())
                .scanPackages("org.example.springcourse.model")
                .addProperties(setProperties())
                .buildSessionFactory();
    }

    private Properties setProperties() {
        Properties hibernateProperties = new Properties();
        try (InputStream input = Start.class.getClassLoader().getResourceAsStream(FILENAME)) {
            hibernateProperties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hibernateProperties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

}
