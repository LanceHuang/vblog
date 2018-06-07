package com.lance.blog.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @author Lance
 * @date 2018/6/7
 */
@Configuration
public class DataSourceConfig {

    @Resource
    private DruidProperties druidProperties;

    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource() throws SQLException {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(druidProperties.getDriverClassName());
        ds.setUrl(druidProperties.getUrl());
        ds.setUsername(druidProperties.getUsername());
        ds.setPassword(druidProperties.getPassword());

        ds.setMinIdle(8);
        ds.setMaxActive(8);
        ds.setFilters(druidProperties.getFilters());

        return ds;
    }

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        servletRegistrationBean.addInitParameter("loginUsername", "lancer");
        servletRegistrationBean.addInitParameter("loginPassword", "123");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
