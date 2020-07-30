package com.springcloud.example.service.conf;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableConfigurationProperties(value = DataSourceProperties.class)
@MapperScan(basePackages = "com.springcloud.example.service.dao")
public class MybatisProperties {

    @Autowired
    private DataSourceProperties dataSourceProperties;
    private final static String mapperLocations = "com.springcloud.service.mybatis/mybatis/*.xml";

    private org.apache.tomcat.jdbc.pool.DataSource pool;

    @RefreshScope
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSourceProperties config = dataSourceProperties;
        this.pool = new org.apache.tomcat.jdbc.pool.DataSource();
        this.pool.setDriverClassName(config.getDriverClassName());
        this.pool.setUrl(config.getUrl());
        if (config.getUsername() != null) {
            this.pool.setUsername(config.getUsername());
        }
        if (config.getPassword() != null) {
            this.pool.setPassword(config.getPassword());
        }
        this.pool.setInitialSize(config.getInitialSize());
        this.pool.setMaxActive(config.getMaxActive());
        this.pool.setMaxIdle(config.getMaxIdle());
        this.pool.setMinIdle(config.getMinIdle());
        this.pool.setTestOnBorrow(config.isTestOnBorrow());
        this.pool.setTestOnReturn(config.isTestOnReturn());
        this.pool.setValidationQuery(config.getValidationQuery());
        return this.pool;
    }

    @PreDestroy
    public void close() {
        if (this.pool != null) {
            this.pool.close();
        }
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean
                .setMapperLocations(resolver.getResources(mapperLocations));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
