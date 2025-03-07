package com.supplychainmanagementsystem.exceptionpackage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.supplychainmanagementsystem.dto.ResponseStructure;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

	
	//Code for handling IdNotFoundException
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handledIdNotFoundException(IdNotFoundException exception)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Id Not Found in Record");
		structure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	//Code for handling NameNotFoundException
	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handledNameNotFoundException(NameNotFoundException exception)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Name Not Found in Record");
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	
	//Code for handling NoRecordFoundException
	@ExceptionHandler(NoRecordFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handledNoRecordFoundException(NoRecordFoundException exception)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("No Record Found in dB");
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
}

