package com.lance.blog.controller;

import com.lance.blog.entity.User;
import com.lance.blog.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author Lance
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("/get")
    public void getUser(@RequestParam(name = "id") int id) {
        User u = userService.getUserById(id);
        System.out.println(u);
        System.out.println("Hello SpringMVC");
        System.out.println("User: " + u);
        // TODO: 2017/11/13 JSON处理
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("welcome.jsp");
//        return mv;
    }


}
