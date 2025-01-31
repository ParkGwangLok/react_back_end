package com.pkr.project.common.interceptor;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.pkr.project.common.utils.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    private final JwtUtil jwtUtil;

    public JwtInterceptor(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // 요청을 처리하기 전에 JWT 토큰을 검증
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);  // "Bearer " 이후의 토큰만 추출

            try {
                // 토큰이 유효한지 검사
                String username = jwtUtil.extractUsername(token);
                if (username != null && jwtUtil.validateToken(token)) {
                    // 토큰이 유효하면 인증된 사용자로 설정
                    request.setAttribute("username", username);  // 필요한 경우 사용자 정보를 요청에 추가
                } else {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write("Invalid or expired token");
                    return false;  // 유효하지 않으면 요청 처리 중단
                }
            } catch (ExpiredJwtException e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Token has expired");
                return false;  // 만료된 토큰인 경우 요청 처리 중단
            }
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Authorization header missing or invalid");
            return false;  // Authorization 헤더가 없으면 요청 처리 중단
        }
        return true;  // 유효한 토큰이면 요청을 처리함
    }
}
