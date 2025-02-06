package com.pkr.project.auth.service;

import org.springframework.stereotype.Service;
import com.pkr.project.auth.mapper.AuthMapper;
import com.pkr.project.user.model.User;

@Service
public class AuthService {
    private final AuthMapper authMapper;

    public AuthService(AuthMapper authMapper) {
        this.authMapper = authMapper;
    }

    public User findByUserId(String userId) {
        return authMapper.findByUserId(userId);
    }
}