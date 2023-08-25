package info.gweep.security5boot2.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories("info.gweep.security5boot2.repository")
@ComponentScan("info.gweep.security5boot2")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class Config {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.driverClassName}")
    private String driver;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddl_auto;
    @Value("${hibernate.show_sql}")
    private String show_sql;
    @Value("${hibernate.format_sql}")
    private String format_sql;
    @Value("classpath:schema.sql")
    private Resource schema;
    @Value("${hibernate.dialect}")
    private String dialect;
//    @Value("${hibernate.current_session_context_class}")
//    private String context_class;
//    @Value("classpath:data.sql")
//    private Resource data;


    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan("info.gweep.security5boot2.entity");
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactory.setJpaProperties(additionalProperties());
        entityManagerFactory.afterPropertiesSet();
        return entityManagerFactory.getObject();
    }

    @Bean
    public ResourceDatabasePopulator populator() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(schema);
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
        hibernateProperties.setProperty("hibernate.dialect", dialect);
        //hibernateProperties.setProperty("hibernate.current_session_context_class", context_class);
        return hibernateProperties;
    }
}
