package com.lance.blog.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

/**
 * @author Lance
 * @date 2018/1/2 10:25
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${jdbc.driverClass}")
    private String driverClass;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

//    @Bean(destroyMethod = "close")
//    public ComboPooledDataSource dataSource() {
//        ComboPooledDataSource ds = null;
//        try {
//            ds = new ComboPooledDataSource();
//            ds.setDriverClass(driverClass);
//            ds.setJdbcUrl(jdbcUrl);
//            ds.setUser(username);
//            ds.setPassword(password);
//
////            ds.setInitialPoolSize(20);
//            ds.setMaxPoolSize(50);
//        } catch (PropertyVetoException e) {
//            logger.error(e.getMessage(), e);
//        }
//        return ds;
//    }

    @Bean(destroyMethod = "close")
    public DruidDataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driverClass);
        ds.setUrl(jdbcUrl);
        ds.setUsername(username);
        ds.setPassword(password);


        ds.setInitialSize(1);
        ds.setMinIdle(1);
        ds.setMaxActive(30);
        try {
            ds.setFilters("stat");
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return ds;
    }

}