package com.pkr.project.common.exception;

public class DuplicateUserException extends BaseException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateUserException() {
        super(ErrorCode.DUPLICATE_USER);
    }
}