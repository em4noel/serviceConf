package com.serviceConf.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
@Configuration
@EnableJpaRepositories(
        basePackages = {"com.serviceConf.Sica" },
        entityManagerFactoryRef = "progressEntityManagerFactory")
public class SicaDbConfig {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.progress")
    public DataSource sicaDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean progressEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("sicaDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.serviceConf.Sica")
                .persistenceUnit("progress")
                .build();
    }
}
