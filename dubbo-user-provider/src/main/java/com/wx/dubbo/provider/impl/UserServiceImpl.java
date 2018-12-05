package com.wx.dubbo.provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.javafaker.Faker;
import com.wx.dubbo.api.domain.User;
import com.wx.dubbo.api.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {
    private static List<User> users = new ArrayList<>();

    @Override
    public User findUser(int id) {
        if (id < 1) {
            throw new IllegalArgumentException("user id < 1, id: " + id);
        }
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        throw new RuntimeException("Can not find user, id: " + id);
    }

    @Override
    public List<User> listUsers() {
        if (users.size() < 100) {
            for (int i = 0; i < 100 - users.size(); ++i) {
                Faker faker = new Faker();
                User user = new User();
                user.setId(i + 1);
                user.setName(faker.name().fullName());
                users.add(user);
            }
        }
        return Collections.unmodifiableList(users);
    }

    @Override
    public User findUserByName(String name) {
        return null;
    }
}
