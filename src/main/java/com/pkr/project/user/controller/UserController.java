package com.pkr.project.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkr.project.user.model.User;
import com.pkr.project.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/selectUser")
    public ResponseEntity<List<User>> getAllUsers(@RequestBody() User user) {
    	List<User> result = userService.getAllUsers(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/insertUser")
    public void insertUser(@RequestBody User user) {
        userService.insertUser(user);
    }
}