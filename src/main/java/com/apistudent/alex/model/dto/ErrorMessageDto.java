package com.apistudent.alex.model.dto;

import java.util.List;

public class ErrorMessageDto {

//	private String title;
//	private String message;
//	private int status;
//	private String path;
//	private String timestamp = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a z Z"));
//
//	public ErrorMessageDto(String title, String message, int status, String path) {
//		this.title = title;
//		this.message = message;
//		this.status = status;
//		this.path = path;
//	}
//
//	public ErrorMessageDto() {
//
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//
//	public int getStatus() {
//		return status;
//	}
//
//	public void setStatus(int status) {
//		this.status = status;
//	}
//
//	public String getPath() {
//		return path;
//	}
//
//	public void setPath(String path) {
//		this.path = path;
//	}
//
//	public String getTimestamp() {
//		return timestamp;
//	}
//
//	public void setTimestamp(String timestamp) {
//		this.timestamp = timestamp;
//	}

	private String message;
	private int code;
	private String status;
	private String objectName;
	private List<ErrorObject> errors;

	public ErrorMessageDto(String message, int code, String status, String objectName, List<ErrorObject> errors) {
		this.message = message;
		this.code = code;
		this.status = status;
		this.objectName = objectName;
		this.errors = errors;
	}

	public ErrorMessageDto() {

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
