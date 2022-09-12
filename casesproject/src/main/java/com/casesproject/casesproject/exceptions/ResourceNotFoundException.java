package com.casesproject.casesproject.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 111L;

	public ResourceNotFoundException(String value) {
		super(ResourceNotFoundException.generateMessage(value));
	}

	public ResourceNotFoundException(String id, String status) {
		super(ResourceNotFoundException.generateMessageWithStatus(status, id));
	}

	private static String generateMessage(String value) {
		return "Resource not found with parameter: " + value;
	}

	private static String generateMessageWithStatus(String value, String id) {
		return "Resource not found with status " + value + "  and id " + id;
	}
}
