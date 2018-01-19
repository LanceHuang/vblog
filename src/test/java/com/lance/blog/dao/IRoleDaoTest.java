package com.lance.blog.dao;

import com.lance.blog.entity.Role;
import com.lance.blog.entity.RoleExample;
import org.junit.Test;
import org.junit.runner.RunWith;
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

    @Resource
    private IRoleDao roleDao;

    @Test
    public void insert() throws Exception {
        System.out.println(roleDao.insert(
                Role.builder().uid(100).name("hello role").build()));
    }

    @Test
    public void countByExample() throws Exception {
        RoleExample roleExample = new RoleExample();
        System.out.println(roleDao.countByExample(roleExample));
    }

    @Test
    public void selectByExample() throws Exception {
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andIdBetween(10, 14);
        System.out.println(roleDao.selectByExample(roleExample));
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        System.out.println(roleDao.selectByPrimaryKey(200));
    }

}