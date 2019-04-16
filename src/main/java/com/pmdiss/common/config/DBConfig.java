package com.pmdiss.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.pmdiss.common.properties.DataSourceProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;


@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
@MapperScan(basePackages = {"com.ajy.core.**.dao"})
public class DBConfig {

    private static final Logger log = LoggerFactory.getLogger(DBConfig.class);

    @Autowired
    private DataSourceProperties dataSourceProperties;


    @Bean
    @Primary
    public DataSource dataSource(){

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
        dataSource.setInitialSize(dataSourceProperties.getInitialSize());
        dataSource.setMinIdle(dataSourceProperties.getMinIdle());
        dataSource.setMaxActive(dataSourceProperties.getMaxActive());
        dataSource.setMaxWait(dataSourceProperties.getMaxWait());
        dataSource.setValidationQuery(dataSourceProperties.getValidationQuery());
        dataSource.setTestOnBorrow(dataSourceProperties.isTestOnBorrow());
        dataSource.setTestWhileIdle(dataSourceProperties.isTestWhileIdle());
        dataSource.setTimeBetweenEvictionRunsMillis(dataSourceProperties.getTimeBetweenEvictionRunsMillis());
        try {
            dataSource.setFilters(dataSourceProperties.getFilters());
        } catch (SQLException e) {
           log.error("设置druid过滤器出现异常，e:{}",e);
        }
        return dataSource;
    }
}
