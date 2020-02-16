package com.test.parser.exception;

public class ErrorResponse {

	String code;
	String message;
	String details;

	public ErrorResponse(String code, String message, String description) {
		super();
		this.code = code;
		this.message = message;
		this.details = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
