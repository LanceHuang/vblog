package com.lance.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 全局配置
 *
 * @author Lance
 */
@Configuration
@ComponentScan(basePackages = {"com.lance.blog.service", "com.lance.blog.dao"})
public class VBlogRootConfig {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setPrefix("/WEB-INF/jsp/");
        vr.setSuffix(".jsp");
        return vr;
    }
}
