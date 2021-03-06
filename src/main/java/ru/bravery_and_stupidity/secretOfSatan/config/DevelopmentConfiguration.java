package ru.bravery_and_stupidity.secretOfSatan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.bravery_and_stupidity.secretOfSatan.model.UserValidator;
import ru.bravery_and_stupidity.secretOfSatan.model.UserValidatorUnit;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Profile("development")
@EnableTransactionManagement
public class DevelopmentConfiguration {

    @Bean(name = "datasource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/secret?useUnicode=true&characterEncoding=utf8");
        dataSource.setUsername("santa");
        dataSource.setPassword("15320666a");
        return dataSource;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DriverManagerDataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setPackagesToScan("ru.bravery_and_stupidity.secretOfSatan.model");
        entityManagerFactory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Map<String, Object> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.hbm2ddl.auto", "update");
        jpaProperties.put("hibernate.show_sql", "true");
        jpaProperties.put("hibernate.format_sql", "true");
        jpaProperties.put("hibernate.use_sql_comments", "true");
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        entityManagerFactory.setJpaPropertyMap(jpaProperties);

        return entityManagerFactory;
    }

    @Bean
    public UserValidator instantiateUserValidator() {
        return UserValidatorUnit.getInstance();
    }
}
