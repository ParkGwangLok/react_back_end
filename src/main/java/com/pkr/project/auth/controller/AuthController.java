package com.pkr.project.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkr.project.common.utils.JwtUtil;
import com.pkr.project.user.model.User;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        // 간단한 사용자 검증 (실제 구현에서는 DB 연동 필요)
        if ("admin".equals(user.getUsername()) && "password".equals(user.getPassword())) {
            String token = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok().body("Bearer " + token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}