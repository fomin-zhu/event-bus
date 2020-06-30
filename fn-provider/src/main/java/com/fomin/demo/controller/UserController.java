package com.fomin.demo.controller;

import com.fomin.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fomin
 * @since 2020/6/30
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/register")
    public String register(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        userService.register(name, age);
        return "register completed!";
    }
}
