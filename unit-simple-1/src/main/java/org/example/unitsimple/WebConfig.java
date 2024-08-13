package org.example.unitsimple;


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
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("org.example")
@EnableJpaRepositories(
        value = "org.example.unitsimple.repository"
        //,
//        entityManagerFactoryRef = "customEntityManagerFactory",
//        transactionManagerRef = "customTransactionManager"
)
@PropertySource("classpath:config.properties")
@EnableTransactionManagement
//@Slf4j
public class WebConfig {

    @Value("${db.driver}")
    private String driver;
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    @Bean//("customTransactionManager")
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }


    @Bean//("customEntityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("org.example.unitsimple.model");
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(setHibernateProperties());
        factoryBean.afterPropertiesSet();
        return factoryBean.getNativeEntityManagerFactory();
    }

//    @PostConstruct
    @Bean
    public Properties setHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.show_sql", "true");
//        properties.put("hibernate.ddl-auto", "create");
        properties.put("hibernate.format_sql", "true");
//        properties.put("generate-ddl", "true");
        return properties;
    }


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, user, password);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }

//    @Bean
//    public ResourceDatabasePopulator databasePopulator() {
//        return new ResourceDatabasePopulator(new ClassPathResource("schema.sql"), new ClassPathResource("insert-data.sql"));
//    }
}
