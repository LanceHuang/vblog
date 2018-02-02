package com.lance.blog.dao;

import com.lance.blog.entity.UserExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    private Logger logger = LoggerFactory.getLogger("test");

    @Resource
    private IUserDao userDao;

    @Test
    public void countByExample() throws Exception {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andIdLessThan(10000)
                .andNameLike("ii%");
        logger.debug("Count: {}", userDao.countByExample(userExample));
    }

    @Test
    public void selectByExample() throws Exception {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andIdLessThan(3)
                .andNameIsNotNull();
        logger.debug("Users: {}", userDao.selectByExample(userExample));
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        logger.debug("User: {}", userDao.selectByPrimaryKey(2));
    }
}

