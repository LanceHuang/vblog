package com.lance.blog.web;

import com.lance.blog.entity.User;
import com.lance.blog.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Lance
 */
@Controller
public class UserController {

    @Resource(name = "userService")
    private IUserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable int id) {
        System.out.println("Hello SpringMVC");
        User u = userService.getUserById(id);
        System.out.println("User: " + u);

        return "welcome";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAllUser() {
        return "welcome";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        System.out.println("Add user: " + user);
        return "welcome";
    }

    @RequestMapping(value = "/test")
    public String test() {
        System.out.println("Test");
        return "welcome";
    }

}
