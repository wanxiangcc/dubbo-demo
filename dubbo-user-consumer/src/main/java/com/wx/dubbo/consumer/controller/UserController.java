package com.wx.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wx.dubbo.api.domain.User;
import com.wx.dubbo.api.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Reference(version = "1.0.0", timeout = 120000)
    private UserService userService;

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable Integer id) {
        return userService.findUser(id);
    }

    @GetMapping("/users")
    public List<User> users() {
        return userService.listUsers();
    }
}
