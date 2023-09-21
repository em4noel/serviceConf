package com.serviceConf.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "biEntityManager",
        transactionManagerRef = "transactionManager",
        basePackages = {"com.serviceConf.Bi"})
public class BiDbConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.bi-datasource")
    public DataSource biDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean biEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("biDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.serviceConf.Bi")
                .persistenceUnit("bi-datasource")
                .build();
    }
    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("biEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
