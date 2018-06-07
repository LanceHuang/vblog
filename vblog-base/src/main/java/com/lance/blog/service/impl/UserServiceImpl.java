package com.lance.blog.service.impl;

import com.lance.blog.dao.IUserDao;
import com.lance.blog.entity.User;
import com.lance.blog.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Lance
 * @since 2017/11/13
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public User getUserById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.selectByExample(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateUserById(User u) {
        if (userDao.updateByPrimaryKey(u) > 0) {
            throw new IllegalArgumentException();
        }

        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addUser(User u) {
        userDao.insert(u);
        return u.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeUserById(Integer id) {
        return userDao.deleteByPrimaryKey(id);
    }
}
