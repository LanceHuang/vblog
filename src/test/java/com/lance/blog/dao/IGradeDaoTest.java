package com.lance.blog.dao;

import com.lance.blog.entity.GradeExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = IGradeDaoTest.class)

@Configuration
@ImportResource("classpath:spring/spring-dao.xml")
public class IGradeDaoTest {

    @Resource
    private IGradeDao gradeDao;

    @Test
    public void countByExample() throws Exception {
        System.out.println(gradeDao.countByExample(new GradeExample()));
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        System.out.println(gradeDao.countByExample(new GradeExample()));
    }


}