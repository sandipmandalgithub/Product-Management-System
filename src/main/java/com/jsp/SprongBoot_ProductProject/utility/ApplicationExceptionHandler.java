package com.jsp.SprongBoot_ProductProject.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	private ErrorStructure<Object>errorStructure;

	public ApplicationExceptionHandler(ErrorStructure<Object> errorStructure) {
		super();
		this.errorStructure = errorStructure;
	}
	@Override
	protected ResponseEntity<Object>handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers,HttpStatusCode status,WebRequest request)
	{
		//List<ObjectError>errors=ex.getAllErrors();
		Map<String,String> messages=new HashMap<>();
		ex.getAllErrors().forEach(error->{
			FieldError fieldError=(FieldError)error;
			messages.put(fieldError.getField(), error.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(
				errorStructure.setErrorStatusCode(HttpStatus.BAD_REQUEST.value())
				.setErrorMessage("Invalid Input")
				.setErrorData(messages)
				);
				
		
	}

}
