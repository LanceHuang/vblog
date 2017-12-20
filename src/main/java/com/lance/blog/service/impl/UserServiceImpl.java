package com.lance.blog.service.impl;

import com.lance.blog.dao.IUserDao;
import com.lance.blog.entity.User;
import com.lance.blog.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Lance
 * @since 2017/11/13
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "userDao")
    private IUserDao userDao;

    @Override
    public User getUserById(int id) {
        logger.debug("UserServiceImpl.getUserById");
        return userDao.select(id);
    }
}
