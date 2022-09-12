package com.casesproject.casesproject.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum Status {
	OPEN("Is Open"),
	CLOSED("Is Closed");
	
	private String code;
	
	Status(String code) {
		this.code=code;
	}

	public static Status decode(final String code) {
		return Stream.of(Status.values()).filter(targetEnum -> targetEnum.name().equals(code)).findFirst().orElse(null);
	}
	
	@JsonValue
	public String getCode() {
		return code;
	}
}
