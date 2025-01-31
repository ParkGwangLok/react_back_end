package com.pkr.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pkr.project.common.interceptor.CommonInterceptor;
import com.pkr.project.common.interceptor.JwtInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") // 모든 경로에 대해 CORS 허용
				.allowedOrigins("http://localhost:3000") // 허용할 도메인
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 메서드
				.allowedHeaders("*") // 모든 헤더 허용
				.allowCredentials(true); // 인증 정보 허용 (쿠키 등)
	}

	private final CommonInterceptor commonInterceptor;
	private final JwtInterceptor jwtInterceptor;
	
    // CommonInterceptor를 생성자 주입으로 받기
    public WebConfig(CommonInterceptor commonInterceptor, JwtInterceptor jwtInterceptor) {
        this.commonInterceptor = commonInterceptor;
        this.jwtInterceptor = jwtInterceptor;
    }

    // 인터셉터 등록
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonInterceptor)
                .addPathPatterns("/api/**")  // /api/** 경로에만 인터셉터 적용
                .excludePathPatterns("/api/auth/**");  // /api/auth/** 경로는 제외
        
        // 두 번째 인터셉터 등록
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/api/**") // /api/another/** 경로에만 적용
                .excludePathPatterns("/api/auth/**"); // 제외할 경로 설정        
    }

}
