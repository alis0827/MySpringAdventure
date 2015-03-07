package com.javanoob.myspring.jpa.context;

import java.util.Properties;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Credits to : Alexey Zvolinskiy
 * http://www.javacodegeeks.com/2013/05/spring-jpa-data-hibernate-mysql-maven.html
 * 
 * This class creates beans that will go to spring Application context.  This
 * is an alternate way of creating spring application context instead of creating
 * an XML file
 * 
 * @author ruel
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.javanoob.myspring.jpa")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("com.javanoob.myspring.jpa")
public class AppContext {
    private static final String PROPERTY_DB_DRIVER="db.driver";
    private static final String PROPERTY_DB_PASSWORD="db.password";
    private static final String PROPERTY_DB_URL="db.url";
    private static final String PROPERTY_DB_USERNAME="db.username";
    private static final String PROPERTY_ENTITYMANAGER_PACKAGES_TO_SCAN="entitymanager.packages.to.scan";
    private static final String PROPERTY_HIBERNATE_DIALECT="hibernate.dialect";
    private static final String PROPERTY_HIBERNATE_SHOW_SQL="hibernate.show_sql";
    
    @Resource
    private Environment env;
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();      
        dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_DB_DRIVER));
        dataSource.setUrl(env.getRequiredProperty(PROPERTY_DB_URL));
        dataSource.setUsername(env.getRequiredProperty(PROPERTY_DB_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PROPERTY_DB_PASSWORD));
        
        return dataSource;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new 
        LocalContainerEntityManagerFactoryBean();       
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPersistenceProviderClass(HibernatePersistence.class);
        entityManagerFactory.setPackagesToScan(env.getProperty(PROPERTY_ENTITYMANAGER_PACKAGES_TO_SCAN));
        entityManagerFactory.setJpaProperties(hibernateProperties());
        
        return entityManagerFactory;        
    }
    
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(PROPERTY_HIBERNATE_DIALECT,
                env.getProperty(PROPERTY_HIBERNATE_DIALECT));
        properties.put(PROPERTY_HIBERNATE_SHOW_SQL, 
                env.getProperty(PROPERTY_HIBERNATE_SHOW_SQL));
        properties.put("hibernate.id.new_generator_mappings", true);
        return properties;
    }
    
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        
        return transactionManager;
    }
}
