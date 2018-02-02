package com.lance.blog.dao;

import com.lance.blog.entity.GradeExample;
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
@ContextConfiguration(classes = IGradeDaoTest.class)

@Configuration
@ImportResource("classpath:spring/spring-dao.xml")
public class IGradeDaoTest {

    private Logger logger = LoggerFactory.getLogger("test");

    @Resource
    private IGradeDao gradeDao;

    @Test
    public void countByExample() throws Exception {
        logger.debug("{}", gradeDao.countByExample(new GradeExample()));
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        logger.debug("{}", gradeDao.selectByExample(new GradeExample()));
    }


}