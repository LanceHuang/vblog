package com.lance.blog.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = IUserDaoTest.class)
@Configuration
@ImportResource("classpath:spring/spring-dao.xml")
public class IUserDaoTest {

    @Resource
    private IUserDao userDao;

    @Test
    public void select() throws Exception {
        System.out.println(userDao.selectByPrimaryKey(2));
    }
}

