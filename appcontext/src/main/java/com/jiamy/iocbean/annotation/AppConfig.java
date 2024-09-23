package com.jiamy.iocbean.annotation;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;

import javax.sql.DataSource;
import java.time.ZoneId;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/9/23 10:11
 **/
@Configuration
public class AppConfig {

    @Bean
    @Qualifier("master")
    @Order(1)
    DataSource createDataSourceMaster(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("root");
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setAutoCommit(true);
        DataSource dataSource = new HikariDataSource(hikariConfig);
        return dataSource;
    }

    @Bean
    @Qualifier("slave")
    @Order(0)
    DataSource createDataSourceSlave(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/test_slave");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("root");
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setAutoCommit(true);
        DataSource dataSource = new HikariDataSource(hikariConfig);
        return dataSource;
    }
}
