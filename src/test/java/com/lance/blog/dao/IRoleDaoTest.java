package com.lance.blog.dao;

import com.lance.blog.entity.Role;
import com.lance.blog.entity.RoleExample;
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
@ContextConfiguration(classes = IRoleDaoTest.class)

@Configuration
@ImportResource("classpath:spring/spring-dao.xml")
public class IRoleDaoTest {

    private Logger logger = LoggerFactory.getLogger("test");

    @Resource
    private IRoleDao roleDao;

    @Test
    public void insert() throws Exception {
        logger.debug("{}", roleDao.insert(
                Role.builder().name("hello role").build()));
    }

    @Test
    public void countByExample() throws Exception {
        RoleExample roleExample = new RoleExample();
        logger.debug("{}", roleDao.countByExample(roleExample));
    }

    @Test
    public void selectByExample() throws Exception {
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andIdBetween(10, 14);
        logger.debug("{}", roleDao.selectByExample(roleExample));
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        logger.debug("{}", roleDao.selectByPrimaryKey(200));
    }

}