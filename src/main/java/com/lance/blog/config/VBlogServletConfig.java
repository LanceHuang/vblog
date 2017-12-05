package com.lance.blog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * DispatcherServlet的配置
 *
 * @author Lance
 */
@Configuration
@ComponentScan(basePackages = {"com.lance.blog.web"})
public class VBlogServletConfig extends WebMvcConfigurationSupport {

    @Override
    protected void configurePathMatch(PathMatchConfigurer configurer) {
        super.configurePathMatch(configurer);
        configurer.setUseSuffixPatternMatch(false);
    }
}
