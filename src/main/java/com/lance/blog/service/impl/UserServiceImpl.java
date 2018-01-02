package com.lance.blog.service.impl;

import com.lance.blog.dao.IUserDao;
import com.lance.blog.entity.User;
import com.lance.blog.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Lance
 * @since 2017/11/13
 */
@Service(value = "userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements IUserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private IUserDao userDao;

    @Override
    public User getUserById(int id) {
        return userDao.select(id);
    }

    @Override
    public int updateUserById(User u) {
        int resultCode = userDao.update(u);
        if (u.getId() < 10) {
            throw new IllegalArgumentException("Test update exeception");
        }
        return resultCode;
    }
}
