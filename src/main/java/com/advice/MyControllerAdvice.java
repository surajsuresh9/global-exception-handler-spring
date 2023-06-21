package com.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.exception.EmptyInputException;

// handles all exceptions globally

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleInputException(EmptyInputException ex) {
		return new ResponseEntity<String>(ex.getErrorMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex) {
		return new ResponseEntity<String>("No such employee found", HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>("Check method type", HttpStatus.NOT_FOUND);
	}
}
