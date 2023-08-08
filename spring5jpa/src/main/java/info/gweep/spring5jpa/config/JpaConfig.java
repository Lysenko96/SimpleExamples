package info.gweep.spring5jpa.config;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("info.gweep.spring5jpa")
@EnableJpaRepositories("info.gweep.spring5jpa.repository")
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaAuditing(auditorAwareRef = "auditorAwareBean")
public class JpaConfig {

    private static final String H2_JDBC_URL_TEMPLATE = "jdbc:h2:tcp://localhost/~/test";
    @Value("classpath:schema.sql")
    private Resource schema;
    @Value("classpath:data.sql")
    private Resource data;


    @Bean
    public DataSource dataSource() {
//        EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
//        return dbBuilder.setType(EmbeddedDatabaseType.H2)
//                .addScripts("classpath:/schema.sql")
//                .addScripts("classpath:/data.sql")
//                .build();
         String jdbcUrl = String.format(H2_JDBC_URL_TEMPLATE, System.getProperty("user.dir"));

        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL(H2_JDBC_URL_TEMPLATE);
        ds.setUser("sa");
        ds.setPassword("");
        databasePopulator().execute(ds);
        return ds;

    }

    @Bean
    public ResourceDatabasePopulator databasePopulator() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(schema);
        populator.addScript(data);
        return populator;
    }

    public Properties hibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernateProp.put("hibernate.format_sql", true);
        hibernateProp.put("hibernate.use_sql_comments", true);
        hibernateProp.put("hibernate.show_ sql", true);
        hibernateProp.put("hibernate.max_fetch_depth", 3);
        hibernateProp.put("hibernate.jdbc.batch_size", 10);
        hibernateProp.put("hibernate.jdbc.fetch_size", 50);

        return hibernateProp;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("info.gweep.spring5jpa.entity");
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.afterPropertiesSet();
        return factoryBean.getNativeEntityManagerFactory();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }
}
