package com.pkr.project.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 모든 사용자 정의 예외 처리
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException ex) {
        ErrorResponse response = ErrorResponse.builder()
            .timestamp(LocalDateTime.now())
            .status(ex.getErrorCode().getStatus().value())
            .error(ex.getErrorCode().getStatus().getReasonPhrase())
            .message(ex.getErrorCode().getMessage())
            .build();

        return new ResponseEntity<>(response, ex.getErrorCode().getStatus());
    }

    // 일반적인 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse response = ErrorResponse.builder()
            .timestamp(LocalDateTime.now())
            .status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus().value())
            .error(ErrorCode.INTERNAL_SERVER_ERROR.getStatus().getReasonPhrase())
            .message(ErrorCode.INTERNAL_SERVER_ERROR.getMessage())
            .build();

        return new ResponseEntity<>(response, ErrorCode.INTERNAL_SERVER_ERROR.getStatus());
    }
}
