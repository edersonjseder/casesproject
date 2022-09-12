package com.casesproject.casesproject.exceptions;

public class UserEmailAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = -8968408139642956360L;

	public UserEmailAlreadyExistsException(String value) {
		super(UserEmailAlreadyExistsException.generateMessage(value));
	}

	private static String generateMessage(String value) {
		return "Email " + value + " already exists.";
	}
}
