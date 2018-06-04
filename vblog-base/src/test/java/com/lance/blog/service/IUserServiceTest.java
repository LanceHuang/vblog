package com.lance.blog.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class IUserServiceTest {

    @Resource
    private IUserService userService;

    @Test
    public void getUserById() {
        System.out.println(userService.getUserById(1));
    }
}