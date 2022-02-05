package com.apistudent.alex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.apistudent.alex.domain.ExceptionMessage;
import com.apistudent.alex.model.dto.ErrorMessageDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorMessageDto> handleStudentNotFoundException(StudentNotFoundException ex){
		return new ResponseEntity<ErrorMessageDto>(new ErrorMessageDto
					(ExceptionMessage.not_found, ex.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
			
	}
	
	@ExceptionHandler(StudentBadRequestException.class)
	public ResponseEntity<ErrorMessageDto> handleStudentBadRequestException(StudentBadRequestException ex){
		return new ResponseEntity<ErrorMessageDto>(new ErrorMessageDto
					(ExceptionMessage.bad_request, ex.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
			
	}
	
	@ExceptionHandler(NullPointerExceptionCustom.class)
	public ResponseEntity<ErrorMessageDto> handleStudentBadRequestException(NullPointerExceptionCustom ex){
		return new ResponseEntity<ErrorMessageDto>(new ErrorMessageDto
					(ExceptionMessage.internal_error, ex.getMessage(), HttpStatus.BAD_GATEWAY), HttpStatus.BAD_GATEWAY);
			
	}

}
