package com.pkr.project.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pkr.project.common.exception.DuplicateUserException;
import com.pkr.project.user.mapper.UserMapper;
import com.pkr.project.user.model.User;
import com.pkr.project.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    public UserServiceImpl(UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers(User user) {
        return userMapper.findAllUsers(user);
    }

    @Override
    public void insertUser(User user) {
        // 중복 체크
    	String resultYn = userMapper.findUserByUsername(user.getUserId());
        if ("Y".equals(resultYn)) {
            throw new DuplicateUserException();
        }

        // 비밀번호 해싱 후 저장
        String pw = passwordEncoder.encode(user.getUserPw());
        user.setUserPw(pw);
        userMapper.insertUser(user);
    }
}
