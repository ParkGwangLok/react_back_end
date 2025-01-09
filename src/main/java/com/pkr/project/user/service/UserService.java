package com.pkr.project.user.service;

import java.util.List;

import com.pkr.project.user.model.User;

public interface UserService {
    List<User> getAllUsers(User user);

    void addUser(User user);
}
