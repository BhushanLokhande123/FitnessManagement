package com.fitness.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fitness.payloads.ApiResponse;


@RestControllerAdvice  //used to handle global exceptions...
public class GlobalExceptionHandler {

	
//whenver this exception occurs in any controller then handler method gets invoked
	//and whole message gets by user...
	@ExceptionHandler(ResourceNotFoundException.class) //which exception to Handle
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
		String message=ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message,LocalDateTime.now());
		return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
	//for input dto validation...
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
			
		Map<String, String> resp = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> { //iterate through all errors
		String fieldName = ((FieldError)error).getField();
		String message = error.getDefaultMessage();
		resp.put(fieldName, message);
		
		});
		
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ApiResponse> httpRequestMethodNotSupportException(HttpRequestMethodNotSupportedException ex)
	{
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message,LocalDateTime.now());
		return new ResponseEntity<>(apiResponse,HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ApiResponse> httpMessageNotReadableException(HttpMessageNotReadableException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message,LocalDateTime.now());
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UnexpectedTypeException.class)
	public ResponseEntity<ApiResponse> unexpectedResponseException(UnexpectedTypeException ex){
		String message = ex.getMessage();
		ApiResponse apiresp = new ApiResponse(message,LocalDateTime.now());
		return new ResponseEntity<ApiResponse>(apiresp,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ApiResponse> dataIntegrityViolationException(DataIntegrityViolationException ex){
		String message = ex.getMessage();
		ApiResponse apiresp = new ApiResponse(message,LocalDateTime.now());
		return new ResponseEntity<ApiResponse>(apiresp,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ApiResponse> constraintViolationException(ConstraintViolationException ex) {
		String message = ex.getMessage();
		ApiResponse apiresp = new ApiResponse(message,LocalDateTime.now());
		return new ResponseEntity<ApiResponse>(apiresp,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(JpaSystemException.class)
	public ResponseEntity<ApiResponse> jpaSystemException(JpaSystemException ex) {
		String message = ex.getMessage();
		ApiResponse apiresp = new ApiResponse(message,LocalDateTime.now());
		return new ResponseEntity<ApiResponse>(apiresp,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ApiResponse> runtimeException(RuntimeException ex) {
		String message = ex.getMessage();
		ApiResponse apiresp = new ApiResponse(message,LocalDateTime.now());
		return new ResponseEntity<ApiResponse>(apiresp,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
