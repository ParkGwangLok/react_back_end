package com.pkr.project.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.pkr.project.common.utils.JwtUtil;
import com.pkr.project.user.model.User;
import com.pkr.project.auth.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final JwtUtil jwtUtil;
    private final AuthService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(JwtUtil jwtUtil, AuthService userService, PasswordEncoder passwordEncoder) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User foundUser = userService.findByUserId(user.getUserId());
        
        if (foundUser != null && passwordEncoder.matches(user.getUserPw(), foundUser.getUserPw())) {
            String token = jwtUtil.generateToken(user.getUserId());
            return ResponseEntity.ok().body("Bearer " + token);
        }

        return ResponseEntity.status(401).body("Invalid credentials");
    }
}