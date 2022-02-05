package com.apistudent.alex.model.dto;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;

import com.apistudent.alex.domain.ExceptionMessage;

public class ErrorMessageDto {
	
	private ExceptionMessage title;
	private String detail;
	private HttpStatus status;
	private String timestamp = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a z Z"));
	
	public ErrorMessageDto(ExceptionMessage title, String detail, HttpStatus status) {
		this.title = title;
		this.detail = detail;
		this.status = status;
	}
	
	public ErrorMessageDto() {
		super();
	}

	public ExceptionMessage getTitle() {
		return title;
	}
	public void setTitle(ExceptionMessage title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
