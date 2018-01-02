package com.lance.blog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Root Config, like ContextLoader
 *
 * @author Lance
 */
@Configuration
@ComponentScan(basePackages = {"com.lance.blog.service", "com.lance.blog.aspect"})
public class VBlogRootConfig {

}
