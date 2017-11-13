package com.lance.blog.dao.impl;

import com.lance.blog.dao.IUserDao;
import com.lance.blog.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author Lance
 * @since 2017/11/13
 */
//@Component(value = "userDao")
public class UserDaoImpl implements IUserDao {

    public User select(int id) {
        System.out.println("UserDaoImpl.select");

        User u = new User();
        u.setName("Lance");
        u.setAge(id * 10);
        return u;
    }
}
