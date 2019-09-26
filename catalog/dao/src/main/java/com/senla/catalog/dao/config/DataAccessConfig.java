package com.senla.catalog.dao.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.senla.catalog"})
public class DataAccessConfig {

    // TODO: 27.09.2019 error 
    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setConnectionProperties(getProperties());

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setPackagesToScan("com.senla.catalog");
        entityManagerFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);

        return entityManagerFactory;
    }

    @Bean
    PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty("connection.driver_class", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("connection.url", "jdbc:mysql://localhost:3306/catalog?serverTimezone=UTC");
        properties.setProperty("connection.username", "qualle");
        properties.setProperty("connection.password", "43q21");
        properties.setProperty("dialect", "org.hibernate.dialect.MySQL8Dialect");

        return properties;
    }
}
