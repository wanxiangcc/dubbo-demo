package com.wx.dubbo.api.service;

import com.wx.dubbo.api.domain.User;

import java.util.List;

public interface UserService {
    User findUser(int id);

    List<User> listUsers();

    User findUserByName(String name);
}
