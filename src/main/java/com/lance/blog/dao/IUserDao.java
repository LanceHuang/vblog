package com.lance.blog.dao;

import com.lance.blog.entity.User;

/**
 * @author Lance
 * @since 2017/11/13
 */
public interface IUserDao {
    User select(int id);

    int update(User user);
}
