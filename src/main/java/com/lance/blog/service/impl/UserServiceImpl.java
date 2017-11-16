package com.lance.blog.service.impl;

import com.lance.blog.dao.IUserDao;
import com.lance.blog.entity.User;
import com.lance.blog.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Lance
 * @since 2017/11/13
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Resource(name = "userDao")
    private IUserDao userDao;

    public User getUserById(int id) {
        System.out.println("UserServiceImpl.getUserById");
        return userDao.select(id);
    }
}
