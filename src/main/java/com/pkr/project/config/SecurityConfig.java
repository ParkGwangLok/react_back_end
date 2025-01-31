package com.pkr.project.config;

import org.springframework.context.annotation.Configuration;

import com.pkr.project.common.utils.JwtUtil;

@Configuration
public class SecurityConfig {
    private final JwtUtil jwtUtil;

    public SecurityConfig(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf(csrf -> csrf.disable())  // CSRF 보호 비활성화 (필요 시 설정 조정 가능)
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/auth/login").permitAll()
//                .anyRequest().authenticated()
//            )
//            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//            .addFilterBefore(new JwtFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
}

