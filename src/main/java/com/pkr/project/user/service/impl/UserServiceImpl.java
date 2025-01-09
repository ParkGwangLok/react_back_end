package com.pkr.project.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pkr.project.user.mapper.UserMapper;
import com.pkr.project.user.model.User;
import com.pkr.project.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Override
    public List<User> getAllUsers(User user) {
        return userMapper.findAllUsers(user);
//        return null;
    }

    @Override
    public void addUser(User user) {
//        userMapper.insertUser(user);
    }
}
