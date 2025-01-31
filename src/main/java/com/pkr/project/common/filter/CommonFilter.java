package com.pkr.project.common.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component  // CommonFilter를 빈으로 등록
public class CommonFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 예: 요청 URL 로그 출력 (로그를 통해 요청을 추적)
        String requestURL = request.getRequestURL().toString();
        String method = request.getMethod();
        System.out.println("Request URL: " + requestURL + " | Method: " + method);

        // 예: 공통적인 헤더 추가 (CORS, 보안 헤더 등)
        response.setHeader("X-Custom-Header", "CustomValue");

        // 요청을 필터 체인으로 전달 (다음 필터나 서블릿으로 진행)
        filterChain.doFilter(request, response);
    }
}

