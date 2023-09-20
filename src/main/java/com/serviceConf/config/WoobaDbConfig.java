package com.serviceConf.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "woobaEntityManager", basePackages = {"com.serviceConf.wooba" } )
public class WoobaDbConfig {
    @Bean
    @ConfigurationProperties(prefix ="spring.wooba-datasource")
    public DataSource WoobaMangerDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean woobaEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("WoobaMangerDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.serviceConf.wooba")
                .persistenceUnit("wooba-datasource")
                .build();
    }
}
