package com.lance.blog.service;

import com.lance.blog.config.PersistentConfig;
import com.lance.blog.config.VBlogRootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {VBlogRootConfig.class, PersistentConfig.class})
public class IUserServiceTest {

    @Resource
    private IUserService userService;

    @Test
    public void getUserById() throws Exception {
        System.out.println(userService.getUserById(1));
    }

    @Test
    public void updateUserById() throws Exception {
    }

}