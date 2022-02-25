package com.apistudent.alex.model.dto;

import java.util.List;

public class ErrorBadRequestDto {

	private String message;
	private int code;
	private String status;
	private String objectName;
	private List<ErrorObject> errors;

	public ErrorBadRequestDto(String message, int code, String status, String objectName, List<ErrorObject> errors) {
		this.message = message;
		this.code = code;
		this.status = status;
		this.objectName = objectName;
		this.errors = errors;
	}

	public ErrorBadRequestDto() {

	}

	public String getMessage() {
		return message;
	}

	public int getCode() {
		return code;
	}

	public String getStatus() {
		return status;
	}

	public String getObjectName() {
		return objectName;
	}

	public List<ErrorObject> getErrors() {
		return errors;
	}

}
