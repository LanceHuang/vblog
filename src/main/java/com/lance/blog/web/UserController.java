package com.lance.blog.web;

import com.lance.blog.entity.User;
import com.lance.blog.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        // TODO: 2017/11/16
        return "welcome";
    }

}
