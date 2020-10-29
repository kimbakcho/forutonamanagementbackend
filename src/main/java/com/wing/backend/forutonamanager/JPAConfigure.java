package com.wing.backend.forutonamanager;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@RequiredArgsConstructor
@EnableTransactionManagement
public class JPAConfigure {

    @Bean
    @Profile("local")
    public DataSource localDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("neoforutonatester");
        dataSource.setPassword("forutona1020");
        dataSource.setUrl("jdbc:mysql://forutonadb.thkomeet.com:3306/forutonamanager_test?serverTimezone=Asia/Seoul&useSSL=yes&verifyServerCertificate=false");
        return dataSource;
    }

    @Bean
    @Profile("test")
    public DataSource testDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("neoforutonatester");
        dataSource.setPassword("forutona1020");
        dataSource.setUrl("jdbc:mysql://forutonadb.thkomeet.com:3306/forutonamanager_test?serverTimezone=Asia/Seoul&useSSL=yes&verifyServerCertificate=false");
        return dataSource;
    }

    @Bean
    @Profile("real")
    public DataSource realDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("neoforutonatester");
        dataSource.setPassword("forutona1020");
        dataSource.setUrl("jdbc:mysql://forutonadb.thkomeet.com:3306/forutonamanager_test?serverTimezone=Asia/Seoul&useSSL=yes&verifyServerCertificate=false");
        return dataSource;
    }

    @Bean
    @Profile("realtest")
    public DataSource realTestDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("neoforutonatester");
        dataSource.setPassword("forutona1020");
        dataSource.setUrl("jdbc:mysql://forutonadb.thkomeet.com:3306/forutonamanager_test?serverTimezone=Asia/Seoul&useSSL=yes&verifyServerCertificate=false");
        return dataSource;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean(name = "entityManagerFactory")
    @Profile("local")
    public LocalContainerEntityManagerFactoryBean localEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(localDataSource());
        em.setPackagesToScan(new String[]{"com.wing.backend.forutonamanager"});
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        Properties jpaProperties = new Properties();

        jpaProperties.put("hibernate.show_sql", "true");
        jpaProperties.put("hibernate.format_sql", "true");
        jpaProperties.put("hibernate.default_batch_fetch_size", "1000");
        jpaProperties.put("hibernate.use_sql_comment", "true");
        em.setJpaProperties(jpaProperties);
        return em;
    }

    @Bean(name = "entityManagerFactory")
    @Profile("test")
    public LocalContainerEntityManagerFactoryBean testEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(testDataSource());
        em.setPackagesToScan(new String[]{"com.wing.backend.forutonamanager"});
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        Properties jpaProperties = new Properties();

        jpaProperties.put("hibernate.dialect", "com.wing.forutona.CustomDialect");
        jpaProperties.put("hibernate.show_sql", "true");
        jpaProperties.put("hibernate.format_sql", "true");
        jpaProperties.put("hibernate.use_sql_comment", "true");
        jpaProperties.put("hibernate.default_batch_fetch_size", "1000");
        em.setJpaProperties(jpaProperties);
        return em;
    }

    @Bean(name = "entityManagerFactory")
    @Profile("real")
    public LocalContainerEntityManagerFactoryBean realEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(realDataSource());
        em.setPackagesToScan(new String[]{"com.wing.backend.forutonamanager"});
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        Properties jpaProperties = new Properties();

//        jpaProperties.put("hibernate.show_sql", "true");
//        jpaProperties.put("hibernate.format_sql", "true");
//        jpaProperties.put("hibernate.use_sql_comment", "true");
        jpaProperties.put("hibernate.default_batch_fetch_size", "1000");
        em.setJpaProperties(jpaProperties);
        return em;
    }

    @Bean(name = "entityManagerFactory")
    @Profile("realtest")
    public LocalContainerEntityManagerFactoryBean RealTestEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(realTestDataSource());
        em.setPackagesToScan(new String[]{"com.wing.backend.forutonamanager"});
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.show_sql", "true");
        jpaProperties.put("hibernate.format_sql", "true");
        jpaProperties.put("hibernate.default_batch_fetch_size", "1000");
        jpaProperties.put("hibernate.use_sql_comment", "true");
        em.setJpaProperties(jpaProperties);
        return em;
    }

    @Bean
    @Primary
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }


}