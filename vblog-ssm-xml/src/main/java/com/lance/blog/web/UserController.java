package com.lance.blog.web;

import com.lance.blog.entity.User;
import com.lance.blog.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        logger.debug("All user info: {}", userService.getAllUser());
        return "welcome";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        logger.debug("Add user: {}", user);
        userService.addUser(user);
        return "welcome";
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public String updateUserById(@RequestBody User user) {
        userService.updateUserById(user);
        return "welcome";
    }
}
