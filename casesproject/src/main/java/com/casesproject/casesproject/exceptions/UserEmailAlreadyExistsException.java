package com.casesproject.casesproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserEmailAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = -8968408139642956360L;

	public UserEmailAlreadyExistsException(String message) {
		super(message);
	}
}
