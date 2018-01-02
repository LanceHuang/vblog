package com.lance.blog.service;

import com.lance.blog.entity.User;

/**
 * @author Lance
 * @since 2017/11/13
 */
public interface IUserService {

    /**
     * Get an user by id
     *
     * @param id user id
     * @return {@code null} if not user found
     */
    User getUserById(int id);


    /**
     * Update user info
     *
     * @param u user info
     * @return return code
     */
    int updateUserById(User u);
}
