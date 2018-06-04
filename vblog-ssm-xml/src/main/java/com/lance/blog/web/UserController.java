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
        User u = userService.getUserById(id);
        logger.debug("User: {}", u);
        return "welcome";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAllUser() {
        return "welcome";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        logger.debug("Add user: {}", user);
        userService.addUser(user);
        return "welcome";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public String updateUserById(String id, @RequestBody User user) {
        userService.updateUserById(user);
        return "welcome";
    }
}
