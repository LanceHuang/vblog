package com.lance.blog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Ugly code, temporarily deal with the problem of mybatis config.
 *
 * @author Lance
 * @date 2018/6/7
 */
@Configuration
@MapperScan(basePackages = "com.lance.blog.dao")
public class PersistentConfig {
}
