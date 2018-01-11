package com.lance.blog.service.impl;

import com.lance.blog.dao.IUserDao;
import com.lance.blog.entity.User;
import com.lance.blog.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Lance
 * @since 2017/11/13
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public User getUserById(int id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public User getUserByIdWithoutTx(int id) {
        return userDao.selectByPrimaryKey(id);
    }


    @Override
    public int updateUserById(User u) {
        return userDao.updateByPrimaryKey(u);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addUser(User u) {
        userDao.insert(u);
        return u.getId();
    }
}
