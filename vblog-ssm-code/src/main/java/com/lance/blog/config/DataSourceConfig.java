package com.lance.blog.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

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

    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driverClass);
        ds.setUrl(jdbcUrl);
        ds.setUsername(username);
        ds.setPassword(password);

        ds.setMinIdle(8);
        ds.setMaxActive(8);
        try {
            ds.setFilters("stat");
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return ds;
    }

}