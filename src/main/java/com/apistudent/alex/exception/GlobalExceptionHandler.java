package com.apistudent.alex.exception;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.apistudent.alex.domain.EnumExceptionMessage;
import com.apistudent.alex.model.dto.ErrorBadRequestDto;
import com.apistudent.alex.model.dto.ErrorNotFoundDto;
import com.apistudent.alex.model.dto.ErrorObject;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
		
	@ExceptionHandler(value= StudentNotFoundException.class)
	public ResponseEntity<ErrorNotFoundDto> handleStudentNotFoundException(StudentNotFoundException ex,
			WebRequest request, HttpServletRequest req){
		
		return new ResponseEntity<ErrorNotFoundDto>(new ErrorNotFoundDto
				(EnumExceptionMessage.NOT_FOUND.getText()
						, ex.getMessage()
						, HttpStatus.NOT_FOUND.value()
						, req.getRequestURI()), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= StudentBadRequestException.class)
	public ResponseEntity<ErrorNotFoundDto> handleStudentBadRequestException(StudentBadRequestException ex,
			WebRequest request, HttpServletRequest req){
		return new ResponseEntity<ErrorNotFoundDto>(new ErrorNotFoundDto
					(EnumExceptionMessage.BAD_REQUEST.getText()
					, ex.getMessage()
					, HttpStatus.BAD_REQUEST.value()
					, req.getRequestURI()), HttpStatus.BAD_REQUEST);
			
	}
	
	@ExceptionHandler(value= Exception.class)
	public ResponseEntity<ErrorNotFoundDto> handleAnyException(Exception e,
			WebRequest request, HttpServletRequest reques){
		return new ResponseEntity<ErrorNotFoundDto>(new ErrorNotFoundDto
					(EnumExceptionMessage.INTERNAL_ERROR.getText()
					, e.getMessage()
					, HttpStatus.INTERNAL_SERVER_ERROR.value()
					, reques.getRequestURI())
					, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
			
	}

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
    		HttpHeaders headers, HttpStatus status, WebRequest request) {
    	
        List<ErrorObject> errors = getErrors(ex);
        ErrorBadRequestDto errorResponse = getErrorResponse(ex, status, errors);
        return new ResponseEntity<>(errorResponse, status);
    }

    private ErrorBadRequestDto getErrorResponse(MethodArgumentNotValidException ex,
    		HttpStatus status, List<ErrorObject> errors) {
    	
        return new ErrorBadRequestDto("Requisição possui campos inválidos", status.value(),
                status.getReasonPhrase(), ex.getBindingResult().getObjectName(), errors);
    }

    private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
                .collect(Collectors.toList());
    }
}
	


