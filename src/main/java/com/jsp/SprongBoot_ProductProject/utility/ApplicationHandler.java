package com.jsp.SprongBoot_ProductProject.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.SprongBoot_ProductProject.exception.ProductNotFoundException;

@RestControllerAdvice
public class ApplicationHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>>productNotFoundByIdException(ProductNotFoundException ex){

		ErrorStructure<String>errorStructure=new ErrorStructure<String>();
		errorStructure.setErrorStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex.getMessage());
		errorStructure.setErrorData("Product with Requested ID is not present into the Database!!");

		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}

}
