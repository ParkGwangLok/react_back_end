package com.pkr.project.common.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CommonInterceptor implements HandlerInterceptor {

    // 요청을 처리하기 전에 실행
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 예: 요청 URL 로그 출력
        System.out.println("Request URL: " + request.getRequestURL());
        
        // 예: 인증 처리, 공통적인 작업 수행
        // 만약 인증이 실패하면 false를 반환하여 요청을 중단할 수 있습니다.
        // if (notAuthenticated) {
        //     response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        //     return false;
        // }
        
        // true를 반환하면 요청을 계속 처리
        return true;
    }

    // 요청을 처리한 후에 실행
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
                           org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {
        // 예: 응답 헤더 추가
        response.setHeader("X-Common-Header", "CommonValue");
    }

    // 요청 처리가 끝난 후에 실행 (View 렌더링 후)
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
                                 Object handler, Exception ex) throws Exception {
        // 예: 로그 기록
        System.out.println("Request completed: " + request.getRequestURL());
    }
}
