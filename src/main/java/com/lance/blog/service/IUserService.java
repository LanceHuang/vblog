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
    User getUserById(Integer id);

    User getUserByIdWithoutTx(Integer id);

    /**
     * Update user info
     *
     * @param u user info
     * @return return code
     */
    int updateUserById(User u);

    /**
     * Add an user
     *
     * @param u user info
     * @return auto-increment id
     */
    int addUser(User u);

    /**
     * Remove an user
     *
     * @param id primary id
     */
    int removeUserById(Integer id);


}
