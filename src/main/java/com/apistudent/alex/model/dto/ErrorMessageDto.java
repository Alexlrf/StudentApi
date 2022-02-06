package com.apistudent.alex.model.dto;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ErrorMessageDto {

	private String title;
	private int status;
	private String path;
	private String timestamp = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a z Z"));

	public ErrorMessageDto(String string, int status, String path) {
		this.title = string;
		this.status = status;
		this.path = path;
	}

	public ErrorMessageDto() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
