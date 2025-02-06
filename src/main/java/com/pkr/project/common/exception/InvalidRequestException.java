package com.pkr.project.common.exception;

public class InvalidRequestException extends BaseException {
    public InvalidRequestException() {
        super(ErrorCode.INVALID_REQUEST);
    }
}