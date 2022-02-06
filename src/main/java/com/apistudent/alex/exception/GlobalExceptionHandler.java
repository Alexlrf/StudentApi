package com.apistudent.alex.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.apistudent.alex.model.dto.ErrorMessageDto;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value= StudentNotFoundException.class)
	public ResponseEntity<ErrorMessageDto> handleStudentNotFoundException(StudentNotFoundException ex, WebRequest request, HttpServletRequest req){
		return new ResponseEntity<ErrorMessageDto>(new ErrorMessageDto
					(ex.getMessage(), HttpStatus.NOT_FOUND.value(), req.getRequestURI()), HttpStatus.NOT_FOUND);
			
	}
	
	@ExceptionHandler(value= StudentBadRequestException.class)
	public ResponseEntity<ErrorMessageDto> handleStudentBadRequestException(StudentBadRequestException ex, WebRequest request, HttpServletRequest req){
		return new ResponseEntity<ErrorMessageDto>(new ErrorMessageDto
					(ex.getMessage(), HttpStatus.BAD_REQUEST.value(), req.getRequestURI()), HttpStatus.BAD_REQUEST);
			
	}
	
	@ExceptionHandler(value= Exception.class)
	public ResponseEntity<ErrorMessageDto> handleAnyException(Exception e, WebRequest request, HttpServletRequest reques){
		return new ResponseEntity<ErrorMessageDto>(new ErrorMessageDto
					(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), reques.getRequestURI()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
			
	}
	

//	
//	@ExceptionHandler(NullPointerExceptionCustom.class)
//	public ResponseEntity<ErrorMessageDto> handleStudentBadRequestException(NullPointerExceptionCustom ex, HttpServletRequest request){
//		return new ResponseEntity<ErrorMessageDto>(new ErrorMessageDto
//					(ExceptionMessage.internal_error, ex.getMessage(), HttpStatus.BAD_GATEWAY.value(), request.getRequestURI()), HttpStatus.BAD_GATEWAY);
//			
//	}

}
