package com.example.springboot.datasource;

import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author clx
 */
@Configuration
public class MySQLDataSource {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().build();
    }
}
