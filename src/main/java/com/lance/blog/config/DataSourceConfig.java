package com.lance.blog.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.beans.PropertyVetoException;

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

    @Bean(destroyMethod = "close")
    public ComboPooledDataSource dataSource() {
        ComboPooledDataSource ds = null;
        try {
            ds = new ComboPooledDataSource();
            ds.setDriverClass(driverClass);
            ds.setJdbcUrl(jdbcUrl);
            ds.setUser(username);
            ds.setPassword(password);
        } catch (PropertyVetoException e) {
            logger.error(e.getMessage(), e);
        }
        return ds;
    }

}
