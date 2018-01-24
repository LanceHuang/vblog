package com.lance.blog.web;

import com.lance.blog.entity.User;
import com.lance.blog.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * @author Lance
 */
@Controller
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "userService")
    private IUserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable int id) {
        logger.trace("getUserById");
        User u = userService.getUserById(id);
        logger.debug("User: {}", u);

        return "welcome";
    }

    @RequestMapping(value = "/user/test", method = RequestMethod.GET)
    public String getUserTest() {
        logger.trace("getUserById");
        User u = userService.getUserById(1);
        logger.debug("User: {}", u);

        return "welcome";
    }

    @RequestMapping(value = "/user/tx", method = RequestMethod.GET)
    public String getUserWithoutTx() {
        logger.trace("getUserById");
        User u = userService.getUserByIdWithoutTx(1);
        logger.debug("User: {}", u);

        return "welcome";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAllUser() {
        logger.trace("getAllUser");
        return "welcome";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        logger.trace("addUser");
        logger.debug("Add user: {}", user);
        userService.updateUserById(user);
        return "welcome";
    }
}
