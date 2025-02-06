package com.pkr.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	// PasswordEncoder Bean 생성
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// HttpSecurity 설정 (보안 설정)
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf().disable()  // CSRF 보호를 비활성화 (REST API 사용시 필요할 수 있음)
//            .authorizeRequests()
//                .requestMatchers("/login", "/register").permitAll() // 로그인, 회원가입은 허용
//                .requestMatchers("/boardList").authenticated() // boardList 페이지는 인증된 사용자만 접근 가능
//                .anyRequest().authenticated() // 나머지 요청은 모두 인증된 사용자만 접근 가능
//            .and()
//            .formLogin() // 폼 로그인 활성화
//                .loginPage("/login") // 커스텀 로그인 페이지 설정
//                .permitAll() // 로그인 페이지는 누구나 접근 가능
//            .and()
//            .logout() // 로그아웃 설정
//                .permitAll(); // 로그아웃은 누구나 접근 가능
//
//        return http.build();  // Spring Boot 3.x에서는 build() 메서드 사용
//    }

	@Bean
	public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception {

		http.securityMatchers((auth) -> auth.requestMatchers("/login"));

		http.authorizeHttpRequests((auth) -> auth.requestMatchers("/login").permitAll());

		return http.build();
	}
}
